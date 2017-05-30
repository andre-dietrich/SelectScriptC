(ns selectscript.disassembler
    (:use [selectscript.utils]  :reload)
    (:use [selectscript.compiler :only (OP op)] :reload))

(declare dis
         dis:key
         dis:data
         dis:prog
         print:space
         whitespace)


(defn dis
  ([code]       (dis code 0 [] 0))
  ([code addr data space]  (dis:prog code addr data space))) ;(first next) (second next)))

(defn dis:data [prog address space]
  (println (format "%d, // %d" (first prog) (byte->uint8 (first prog))))
  (loop [i     (byte->uint8 (first prog))
         data  (rest prog)
         addr  (inc address)
         word []]
    (if (zero? i)
      [data addr word]
      (let [[new_data
             new_addr
             new_word]  (do
                          (print:space space)
                          (print (format "%d, " (first data)))
                          (loop [d (rest data) a (inc addr) w "\""]
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
       (if (empty? elements)
         val
         (recur elements))))))

(defn dis:prog [prog addr data space]
  (let [code (rest prog)
        [op_code pop] (if (< (first prog) 0)
                        [(dis:key (+ 128 (first prog))) true]
                        [(dis:key (first prog)) false])]
    (print (format "/*%04d*/" addr))
    (if (and (keyword? op_code)
             (not (= :OP op_code))
             (not (= :OPX op_code)))
      (print (clojure.string/join (repeat space whitespace))
             (format "%-13s" (str (name op_code) (if pop "|P," ","))))
      (print (clojure.string/join (repeat space whitespace))))
    (condp contains? op_code
      #{:SP_SAVEX}  (let [[c a d] (dis:data code (inc addr) (inc space))]
                      (print:space space)
                      (println (str whitespace (first c) ", // local variables"))
                      (dis:prog (rest c) (inc a) d space))
      #{:SP_SAVE}   (do
                      (println (str (first code) ", // local variables"))
                      (let [[c a d] (dis:prog (rest code) (+ 2 addr) data space)]
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
      #{:CST_DCT}   (let [len (byte->uint16 (take 2 code))]
                      (println (format "%d, %d, // %d"
                                    (nth code 0)
                                    (nth code 1)
                                    len))
                      (loop [i len, c (nthrest code 2), a (+ addr 2)]
                        (if (zero? i)
                          (do
                            (dis:prog c (inc a) data space))
                          (do
                            (print:space (inc space))
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
      #{:PROC}      (do
                      (println (format "%d, // help: %s"
                                       (first code)
                                       (nth data (byte->uint8 (first code)))))
                      (print:space (inc space))
                      (println (format "%d, %d, // length: %d"
                                       (nth code 1)
                                       (nth code 2)
                                       (byte->uint16 (list (nth code 1)
                                                           (nth code 2)))))
                      (println "//////////////////////////////////////////////////////////")
                      (let [[c a _] (dis:prog (nthrest code 3) (+ 3 addr) [] (inc space))]
                        (println "//////////////////////////////////////////////////////////")
                        (dis:prog c a data space)))
      (if (or (not (keyword? op_code))
              (= :OP op_code)
              (= :OPX op_code))
        (let [op_code2 (case op_code
                         :OP  (:OP OP)
                         :OPX (:OPX OP)
                         op_code)]
          (if (<= (:OPX OP) op_code2)
            (println (format " OPX|%-8s %d, // params: %d"
                             (str (name (dis:key (- op_code2 (:OPX OP)) op))
                                  (if pop "|P," ","))
                             (first code)
                             (inc (byte->uint8 (first code)))))
            (println (format " OP|%-9s %d, // params: %d"
                             (str (name (dis:key (- op_code2 (:OP OP)) op))
                                  (if pop "|P," ","))
                             (first code)
                             (inc (byte->uint8 (first  code))))))
          (dis:prog (rest code) (+ 2 addr) data space))

        (do
          (println)
          (dis:prog code (inc addr) data space))))))


(def whitespace "              ")

(defn print:space
  ([space]      (print:space space true))
  ([space addr] (print (str (if addr "        ") (clojure.string/join (repeat space whitespace))))))
