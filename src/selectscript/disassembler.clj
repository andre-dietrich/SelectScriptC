(ns selectscript.disassembler
    (:use [selectscript.utils]  :reload)
    (:use [selectscript.compiler :only (OP op)] :reload))

(declare dis
         dis:key
         dis:data
         dis:prog)


(defn dis
  ([code]       (dis code 0))
  ([code addr]  (let [next (dis:data code addr)]
                  (dis:prog (first next) (second next)))))

(defn dis:data [prog address]
  (println "/// DATA:" (byte->uint16 (take 2 prog)))
  (println (format "%d, %d," (first prog) (second prog)))
  (loop [words (byte->uint16 (take 2 prog))
         data  (nthrest prog 2)
         addr  (+ address 1)]
    (if (zero? words)
      [data addr]
      (let [[new_data new_addr] (loop [d data a addr]
                                  (let [c (first d)]
                                    (print (if (<= 32 c 126)
                                             (format "'%s', " (char c))
                                             (format "%d, " c))))
                                  (if (= 0 (first d))
                                    (do
                                      (println)
                                      [(rest d) a])
                                    (recur (rest d) (inc a))))]
        (recur (dec words) new_data (inc new_addr))))))

(defn dis:key
  ([val]
   (dis:key val OP))
  ([val base]
   (loop [[[k v] & elements] (into [] base)]
     (if (= v val)
       k
       (recur elements)))))

(defn dis:prog [prog address]
  (println "/// PROGRAM:")
  (with-local-vars [op_code (first prog), code (rest prog), addr (inc address)]
    (while (not= nil @op_code)
      (do
        (if (< @op_code 0)
          (do
            (var-set op_code (dis:key (+ @op_code 128)))
            (print (format "%-10s " (str (name @op_code) "|POP,"))))
          (do
            (var-set op_code (dis:key @op_code))
            (print (format "%-10s " (str (name @op_code) ",")))))
        (condp contains? @op_code
          #{:CST_LST
            :CST_SET}   (do
                          (println (format "%d, %d, // %d"
                                           (nth @code 0)
                                           (nth @code 1)
                                           (byte->uint16 (take 2 @code))))
                          (var-set code (nthrest @code 2))
                          (var-set addr (+ @addr 2)))

          #{:CST_F}     (do
                          (println (format "%d, %d, %d, %d, // %f"
                                           (nth @code 0)
                                           (nth @code 1)
                                           (nth @code 2)
                                           (nth @code 3)
                                           (byte->float (take 4 @code))))
                          (var-set code (nthrest @code 4))
                          (var-set addr (+ @addr 4)))

          #{:CST_S}     (do
                          (println (format "%d, %d, // %d"
                                           (nth @code 0)
                                           (nth @code 1)
                                           (byte->int16 (take 2 @code))))
                          (var-set code (nthrest @code 2))
                          (var-set addr (+ @addr 2)))

          #{:CST_I}     (do
                          (println (format "%d, %d, %d, %d, // %d"
                                           (nth @code 0)
                                           (nth @code 1)
                                           (nth @code 2)
                                           (nth @code 3)
                                           (byte->int32 (take 4 @code))))
                          (var-set code (nthrest @code 4))
                          (var-set addr (+ @addr 4)))

          #{:CST_DCT}   (let [len (byte->uint8 (first @code))]
                          (println (str (first @code) ", // " len))
                          (print "           ")
                          (var-set code (rest @code))
                          (var-set addr (+ 1 len @addr))
                          (loop [i len]
                            (if (> i 0)
                              (do
                                (print (str "" (first @code) ", "))
                                (var-set code (rest @code))
                                (recur (dec i)))))
                          (println))

          #{:TRY_1
            :FJUMP
            :JUMP}      (do
                          (println (format "%d, %d, // %d"
                                           (nth @code 0)
                                           (nth @code 1)
                                           (byte->int16 (take 2 @code))))
                          (var-set code (nthrest @code 2))
                          (var-set addr (+ @addr 2)))

          #{:CALL_FCT
            :CALL_FCTX
            :CST_STR
            :IT_AS
            :LOAD
            :LOC
            :LOCX
            :STORE
            :STORE_LOC} (do
                          (println (str (first @code)
                                        ", // "
                                        (byte->uint8 (first @code))))
                          (var-set code (nthrest @code 1))
                          (var-set addr (inc @addr)))

          #{:CST_B}     (do
                          (println (str (first @code) ", "))
                          (var-set code (nthrest @code 1))
                          (var-set addr (inc @addr)))

          #{:CALL_OP
            :CALL_OPX}  (do
                          (println (format "%d, %s, // %d, %d"
                                           (first @code)
                                           (name (dis:key (second @code) op))
                                           (byte->uint8 (first  @code))
                                           (byte->uint8 (second @code))))
                          (var-set code (nthrest @code 2))
                          (var-set addr (+ 2 @addr)))

          #{:PROC}      (do
                          (println (format "%d, %d, %d // %d, %d"
                                           (nth @code 0)
                                           (nth @code 1)
                                           (nth @code 2)
                                           (byte->uint8  (first @code))
                                           (byte->uint16 (list (nth @code 1)
                                                               (nth @code 2)))))
                          (let [[new_code new_addr] (dis:data (nthrest @code 3)
                                                              (+ 3 @addr))]
                            (var-set code new_code)
                            (var-set addr new_addr)))
          (println))

        (var-set op_code (first @code))
        (var-set code    (rest  @code))
        (var-set addr    (inc   @addr))))))
