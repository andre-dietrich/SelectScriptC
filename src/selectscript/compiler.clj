(ns selectscript.compiler
    (:use [selectscript.parser]     :reload)
    (:use [selectscript.optimizer]  :reload)
    (:use [selectscript.interim]    :reload)
    (:use [selectscript.utils]      :reload))


(def op { :not   0,   :neg   1,
          :add   2,   :sub   3,   :mul   4,   :div   5,   :mod  6,   :pow  7,
          :lt    8,   :le    9,   :ge   10,   :gt   11,   :ne  12,   :eq  13,
          :and  14,   :xor  15,   :or   16,   :in   17,
          :inv  18,   :iand 19,   :ior  20,   :ixor 21,
          :ilshift 22, :irshift 23
          :ex 24})

(def OP { :RET 0, :RET_L 1, :RET_P 2,
          :SP_SAVE 3,
          :CST_N 4, :CST_0 5, :CST_1 6, :CST_B 7, :CST_S 8, :CST_I 9, :CST_F 10,
          :CST_STR 11, :CST_LST 12, :CST_SET 13, :CST_DCT 14,
          :LOAD 15, :ELEM 16,
          :STORE 17, :STORE_RF 18, :STORE_LOC 19,
          :CALL_OPX 20, :CALL_OP 21,
          :CALL_FCTX 22, :CALL_FCT 23,
          :FJUMP 24, :JUMP 25,
          :PROC 26,
          :LOC 27, :LOCX 28,
          :IT_INIT 29,
          :IT_NEXT0 30, :IT_NEXT1 31, :IT_NEXT2 32, :IT_NEXT3 33,
          :IT_STORE 34, :IT_LIMIT 35, :IT_GROUP 36, :IT_ORDER 37, :IT_AS 38,
          :EXIT 39, :TRY 40, :REF 41})

(declare compi
         compi:cmd
         compi:data
         conc)


(defn compi:cmd [args]
  (list (first args)
        (if (= 2 (count args))
          true
          false)))

(defn compi:data [repo string]
  (let [pos (.indexOf repo string)]
    (if (< pos 0)
      [(conc repo [string]) (count repo)]
      [repo pos])))

(defn compi
  ([code] (let [[data asm] (compi code [] [])]
            (conc (uint16->byte (count data))
                  (loop [d data bytes []]
                    (println "data" d)
                    (if (empty d)
                      bytes
                      (recur (rest d)
                             (conc bytes (string->byte d)))))
                  asm)))
  ([code data asm]
   (println "compi" code data asm)
   (if (not (empty? code))
     (let [[cmd pop] (compi:cmd (first code))]
       (let [asm_ (conc asm [(+ (cmd OP)
                               (if pop 128 0))])]
         (println "XXXXXXXXXXXXXXXXXXXxx" asm_)
         (condp contains? cmd
           #{:CST_B}    (compi (nthrest code 2)
                               data
                               (conc asm_ (int8->byte (second code))))
           #{:CST_F}    (compi (nthrest code 2)
                               data
                               (conc asm_ (float->byte (second code))))
           #{:CST_I}    (compi (nthrest code 2)
                               data
                               (conc asm_ (int32->byte (second code))))

           #{:CST_LST
             :CST_SET}  (compi (nthrest code 2)
                               data
                               (conc asm_ (uint16->byte (second code))))
           #{:CST_S}    (compi (nthrest code 2)
                               data
                               (conc asm_ (int16->byte (second code))))
           #{:CST_STR
             :LOC
             :STORE
             :STORE_LOC
             :LOAD}     (let [[data_ i] (compi:data data (second code))]
                          (compi (nthrest code 2)
                                 data_
                                 (conc asm_ [i])))
           #{:CALL_FCTX
             :CALL_FCT} (compi (nthrest code 2)
                               data
                               (conc asm_ (uint8->byte (second code))))
           #{:CALL_OPX
             :CALL_OP}  (compi (nthrest code 3)
                               data
                               (conc asm_
                                     [((nth code 1) op)]
                                     (uint8->byte(nth code 2))))
           #{:SP_SAVE}  (let [[c d a] (compi (rest code)
                                             data
                                             asm_)]
                          (compi c d a))
           #{:RET
             :RET_L
             :RET_P}      [(rest code) data asm_]
           (compi (rest code) data asm_))))

     [data asm])))

(defn conc [a & b]
  (if (empty? b)
    a
    (recur (into [] (concat a (first b)))
           (rest b))))

(compi (interim (parse "12;")))
