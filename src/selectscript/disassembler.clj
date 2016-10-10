(ns selectscript.disassembler
    (:use [selectscript.utils]  :reload)
    (:use [selectscript.compiler :only (OP op)] :reload))

(declare dis
         dis:key
         dis:data
         dis:prog)


(defn dis
  ([code]       (dis code 0 [] 0))
  ([code addr data space]  (dis:prog code addr data space))) ;(first next) (second next)))

(defn dis:data [prog address space]
  (println (format "%d, %d, // %d" (first prog) (second prog) (byte->uint16 (take 2 prog))))
  (loop [i     (byte->uint16 (take 2 prog))
         data  (nthrest prog 2)
         addr  (+ address 2)
         word []]
    (if (zero? i)
      [data addr word]
      (let [[new_data
             new_addr
             new_word]  (do
                          (print "        " (clojure.string/join (repeat space "           ")))
                          (loop [d data a addr w "\""]
                            (let [c (first d)]
                              (print (if (<= 32 c 126)
                                       (format "'%s', " (char c))
                                       (format "%d, " c)))
                              (if (zero? c)
                                (do
                                  (println "// " (str w "\""))
                                  [(rest d) a (str w "\"")])
                                (recur (rest d) (inc a) (str w (char c)))))))]
        (recur (dec i) new_data (inc new_addr) (conj word new_word))))))

(defn dis:key
  ([val]
   (dis:key val OP))
  ([val base]
   (loop [[[k v] & elements] (into [] base)]
     (if (= v val)
       k
       (recur elements)))))

(defn dis:prog [prog addr data space]
  (let [code (rest prog)
        [op_code pop] (if (< (first prog) 0)
                        [(dis:key (+ 128 (first prog))) true]
                        [(dis:key (first prog)) false])]
    (print (format "/*%04d*/" addr))
    (print (clojure.string/join (repeat space "           "))
           (format "%-11s" (str (name op_code) (if pop "|POP," ","))))
    (condp contains? op_code
      #{:SP_SAVEX}  (let [[c a d] (dis:data code (inc addr) (inc space))]
                      (dis:prog c a d space))
      #{:SP_SAVE}   (do
                      (println)
                      (let [[c a d] (dis:prog code (inc addr) data space)]
                        (if (not-empty c)
                          (dis:prog c a data space))))
      #{:RET_P
        :RET}       (do
                      (println)
                      [code (inc addr) data])
      #{:EXIT
        :REC_SET}   (do
                      (println (format "%d," (first code)))
                      (dis:prog (rest code) (inc addr) data space))
      #{:CST_LST
        :CST_SET}   (do
                      (println (format "%d, %d, // %d"
                                       (first  code)
                                       (second code)
                                       (byte->uint16 (take 2 code))))
                      (dis:prog (nthrest code 2) (+ 3 addr) data space))
      #{:CST_F}     (do
                      (println (format "%d, %d, %d, %d, // %f"
                                       (nth code 0)
                                       (nth code 1)
                                       (nth code 2)
                                       (nth code 3)
                                       (byte->float (take 4 code))))
                      (dis:prog (nthrest code 4) (+ 5 addr) data space))
      #{:TRY_1
        :FJUMP
        :JUMP
        :CST_S}     (do
                      (println (format "%d, %d, // %d"
                                       (first  code)
                                       (second code)
                                       (byte->int16 (take 2 code))))
                      (dis:prog (nthrest code 2) (+ 3 addr) data space))

      #{:CST_I}     (do
                      (println (format "%d, %d, %d, %d, // %d"
                                       (nth code 0)
                                       (nth code 1)
                                       (nth code 2)
                                       (nth code 3)
                                       (byte->int32 (take 4 code))))
                      (dis:prog (nthrest code 4) (+ 5 addr) data space))
      #{:CST_DCT}   (let [len (byte->uint8 (first code))]
                      (println (str (first code) ", // " len))
                      (loop [i len, c (rest code), a (inc addr)]
                        (if (zero? i)
                          (dis:prog c a data space)
                          (do
                            (print "       " (clojure.string/join (repeat (inc space) "            ")))
                            (print (str "" (first c) ", "))
                            (println "//" (nth data (byte->uint8 (first c))))
                            (recur (dec i) (rest c) (inc a))))))

      #{:LOAD
        :CST_STR
        :LOC
        :LOCX
        :STORE
        :STORE_LOC} (do
                      (println (format "%d, // %s"
                                       (first code)
                                       (nth data (byte->uint8 (first code)))))
                      (dis:prog (rest code) (+ 2 addr) data space))

      #{:CALL_FCT
        :CALL_FCTX
        :IT_AS}     (do
                      (println (str (first code)
                                    ", // "
                                    (byte->uint8 (first code))))
                      (dis:prog (rest code) (+ 2 addr) data space))

      #{:CST_B}     (do
                      (println (str (first code) ", "))
                      (dis:prog (rest code) (+ 2 addr) data space))
      #{:CALL_OP
        :CALL_OPX}  (do
                      (println (format "%d, %s, // params: %d, op: %d"
                                       (first code)
                                       (name (dis:key (second code) op))
                                       (byte->uint8 (first  code))
                                       (byte->uint8 (second code))))
                      (dis:prog (nthrest code 2) (+ 3 addr) data space))

      #{:PROC}      (do
                      (println (format "%d, // help: %s"
                                       (first code)
                                       (nth data (byte->uint8 (first code)))))
                      (print "       " (clojure.string/join (repeat (inc space) "            ")))
                      (println (format "%d, %d, // length: %d"
                                       (nth code 1)
                                       (nth code 2)
                                       (byte->uint16 (list (nth code 1)
                                                           (nth code 2)))))
                      (println "//////////////////////////////////////////////////////////")
                      (let [[c a _] (dis:prog (nthrest code 3) (+ 3 addr) [] (inc space))]
                        (println "//////////////////////////////////////////////////////////")
                        (dis:prog c a data space)))
      (do
        (println)
        (dis:prog code (inc addr) data space)))))
