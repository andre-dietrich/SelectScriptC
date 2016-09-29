(ns selectscript.compiler
  (:use [selectscript.utils]    :reload))



(def op { :NOT    0, :NEG    1,
          :ADD    2, :SUB    3, :MUL    4,
          :DIV    5, :MOD    6, :POW    7,
          :LT     8, :LE     9, :GE    10,
          :GT    11, :NE    12, :EQ    13,
          :AND   14, :XOR   15, :OR    16,
          :IN    17,
          :B_NOT 18, :B_AND 19,
          :B_OR  20, :B_XOR 21,
          :LEFT  22, :RIGHT 23,
          :EX    24})

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
          :EXIT 39, :TRY_1 40, :TRY_0 41, :REF 42})

(declare cmp
         cmp:cmd
         cmp:data
         cmp:base
         cmp:proc
         conc)


(defn cmp:cmd [args]
  (list (first args)
        (if (= 2 (count args))
          true
          false)))

(defn cmp:data [repo string]
  (let [pos (.indexOf repo string)]
    (if (< pos 0)
      [(conc repo [string]) (count repo)]
      [repo pos])))

(defn cmp:base [code data asm fct]
  (cmp (rest code)
       data
       (conc asm (fct (first code)))))

(defn cmp
  ([code] (let [[data asm] (cmp code [] [])]
            (map #(if (< 127 %) (- % 256) %)
                 (conc (uint16->byte (count data))
                   (loop [d data bytes []]
                     (if (empty? d)
                       bytes
                       (recur (rest d)
                              (conc bytes (string->byte (first d))))))
                   asm))))

  ([code data asm]
   ;(println "->>>>>" code data asm)
   (if (empty? code)
     [data asm]
     (let [[cmd pop] (cmp:cmd (first code))]
       (let [asm_ (if (contains? OP cmd)
                    (conc asm [(+ (cmd OP)
                                  (if pop 128 0))])
                    asm)]
         (if (and pop (.contains [:CST_N :CST_0 :CST_1] cmd))
           (cmp (rest code) data asm)
           (if (and pop (.contains [:CST_B :CST_S :CST_I :CST_F] cmd))
             (cmp (nthrest code 2) data asm)
             (condp contains? cmd
               #{:IT_GROUP} (cmp:base (rest code) data asm_ uint8->byte)
               #{:CST_B}    (cmp:base (rest code) data asm_ int8->byte)
               #{:CST_F}    (cmp:base (rest code) data asm_ float->byte)
               #{:CST_I}    (cmp:base (rest code) data asm_ int32->byte)
               #{:CST_LST
                 :CST_SET}  (cmp:base (rest code) data asm_ uint16->byte)
               #{:CST_S}    (cmp:base (rest code) data asm_ int16->byte)
               #{:CST_DCT}
               (let [[data_ ids_] (loop [d data, i [], keys (second code)]
                                    (if (empty? keys)
                                      [d i]
                                      (let [[D I] (cmp:data d (first keys))]
                                        (recur D (conc i [I]) (rest keys)))))]
                 (cmp (nthrest code 2)
                      data_
                      (conc asm_ [(count ids_)] ids_)))
               #{:LOAD}
               (let [[data_ i] (cmp:data data (second code))]
                 (if (= [(+ 128 (:STORE OP)) i]
                        (take-last 2 asm))
                   (cmp (rest code)
                        data_
                        (conc (drop-last 2 asm)
                              [(:STORE OP) i]))
                   (cmp:base (conj (nthrest code 2) i) data_ asm_ list)))
               #{:LOC}
               (let [[data_ i] (cmp:data data (second code))]
                 (if (= [(+ 128 (:STORE_LOC OP)) i]
                        (take-last 2 asm))
                   (cmp (rest code)
                        data_
                        (conc (drop-last 2 asm)
                              [(:STORE_LOC OP) i]))
                   (cmp:base (conj (nthrest code 2) i) data_ asm_ list)))
               #{:CST_STR :LOC :LOCX :STORE :STORE_LOC}
               (let [[data_ i] (cmp:data data (second code))]
                 (cmp:base (conj (nthrest code 2) i) data_ asm_ list))
               #{:CALL_FCTX
                 :CALL_FCT} (cmp:base (rest code) data asm_ uint8->byte)
               #{:CALL_OP :CALL_OPX}
               (cmp (nthrest code 3)
                    data
                    (conc asm_
                          (uint8->byte (nth code 2))
                          [((nth code 1) op)]))
               #{:SP_SAVE}
               (let [[c d a] (cmp (rest code)
                                  data
                                  asm_)]
                 (cmp c d a))
               #{:RET :RET_L :RET_P
                 :THEN_END :ELSE_END
                 :LOOP_END :TRY_END
                 :JUMP_END}
               [(rest code) data asm_]
               #{:LOOP_BEGIN}
               (let [loop_ (cmp (rest code) data [])]
                 (cmp (first loop_)
                      (second loop_)
                      (conc asm_
                            (last loop_)
                            (:JUMP OP)
                            (int16->byte (- -1 (count (last loop_)))))))

               #{:IF}
               (let [then (cmp (rest code) data [])]
                 (let [else (cmp (first then)
                                 (second then)
                                 [])]
                   (cmp (first else)
                        (second else)
                        (conc asm_
                              (:FJUMP OP) (int16->byte (+ 5 (count (last then))))
                              (last then)
                              (:JUMP OP)  (int16->byte (+ 2 (count (last else))))
                              (last else)))))
               #{:TRY_1}
               (let [try_code (cmp (rest code) data [])]
                 (let [catch_code (cmp (first try_code) (second try_code) [])]
                   (cmp (first  catch_code)
                        (second catch_code)
                        (conc  asm_
                               (int16->byte (+ 4 (count (last try_code))))
                               (last try_code)
                               (:TRY_0 OP)
                               (:JUMP OP)
                               (int16->byte (+ 2 (count (last catch_code))))
                               (last catch_code)))))
               #{:PROC}
               (cmp:proc (rest code) data asm_)

               #{:IT_AS}
               (cmp (nthrest code 2) data (conc asm_ (second code)))

               #{:IT_LIMIT}
               (cmp (rest code) data (conc asm_ (:FJUMP OP) (int16->byte 5)))

               #{:FJUMP_FW_X}
               (let [overhead (second code)
                     new (cmp (nthrest code 2) data ())]
                 (cmp (first new)
                      (second new)
                      (concat asm_
                              [(:FJUMP OP)]
                              (int16->byte (+ (count (last new)) overhead))
                              (last new))))

               #{:FJUMP_WHERE}
               (let [new (cmp (rest code) data [])]
                 (cmp (first new)
                      (second new)
                      (concat asm_
                              (last new)
                              [(:FJUMP OP)]
                              (int16->byte (- (- (count (last new))) 5)))))

               #{:FJUMP_BK_X}
               (let [overhead1 (nth code 1)
                     overhead2 (nth code 2)
                     new (cmp (nthrest code 3) data [])]
                 (cmp (first new)
                      (second new)
                      (concat asm_
                              [(:FJUMP OP)]
                              (int16->byte (+ overhead1 (count (last new))))
                              (last new)
                              [(:JUMP OP)]
                              (int16->byte (- overhead2 (count (last new)))))))

               (cmp (rest code) data asm_)))))))))


(defn cmp:proc [[info code_proc & code] data asm]
  (let [[i_data, i_id] (cmp:data data info)
        proc_asm (cmp code_proc)]
    (cmp code
         i_data
         (conc asm
               (uint8->byte i_id)
               (uint16->byte (count proc_asm))
               proc_asm))))



(defn conc [a & b]
  (if (empty? b)
    a
    (recur (let [element (first b)]
             (if (integer? element)
               (conj a element)
               (into [] (concat a element))))
           (rest b))))
