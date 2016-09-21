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
  (println "//DATA:\n" (byte->uint16 (take 2 prog)))
  (loop [words (byte->uint16 (take 2 prog))
         data  (nthrest prog 2)
         addr  (+ address 1)]
    (if (zero? words)
      [data addr]
      (let [[new_data new_addr] (loop [d data a addr]
                                  (print (char (first d)))
                                  (if (= 0 (first d))
                                    (do
                                      (print ",")
                                      [(rest d) a])
                                    (recur (rest d) (inc a))))]
        (recur (dec words) new_data (inc new_addr))))))

(defn dis:key [val]
  (loop [[[k v] & elements] (into [] OP)]
    (if (= v val)
      k
      (recur elements))))

(defn dis:prog [prog address]
  (println "\nPROGRAM:")
  (with-local-vars [op_code (first prog), code (rest prog), addr (inc address)]
    (while (not= nil @op_code)
      (do
        (if (< @op_code 0)
          (do
            (var-set op_code (dis:key (+ @op_code 128)))
            (print (format "%-5d%-14s" @addr (str @op_code "|P"))))
          (do
            (var-set op_code (dis:key @op_code))
            (print (format "%-5d%-14s" @addr (str @op_code)))))
        (condp contains? @op_code
          #{:CST_LST
            :CST_SET}   (do
                          (println (byte->uint16 (take 2 @code)))
                          (var-set code (nthrest @code 2))
                          (var-set addr (+ @addr 2)))

          #{:CST_F}     (do
                          (println (byte->float (take 4 @code)))
                          (var-set code (nthrest @code 4))
                          (var-set addr (+ @addr 4)))

          #{:CST_S}     (do
                          (println (byte->int16 (take 2 @code)))
                          (var-set code (nthrest @code 2))
                          (var-set addr (+ @addr 2)))

          #{:CST_I}     (do
                          (println (byte->int16 (take 4 @code)))
                          (var-set code (nthrest @code 4))
                          (var-set addr (+ @addr 4)))

          #{:CST_DCT}   (let [len (byte->uint8 (first @code))]
                          (var-set code (rest @code))
                          (var-set addr (+ 1 len @addr))
                          (print len)
                          (loop [i len]
                            (if (> i 0)
                              (do
                                (print "" (byte->uint8 (first @code)))
                                (var-set code (rest @code))
                                (recur (dec i)))))
                          (println))

          #{:FJUMP
            :JUMP}      (do
                          (println (byte->int16 (take 2 @code)))
                          (var-set code (nthrest @code 2))
                          (var-set addr (+ @addr 2)))

          #{:TRY}       (let [val (byte->int8 (first @code))]
                          (var-set code (rest @code))
                          (if (= 0 val)
                            (do
                              (println 0)
                              (var-set addr (inc @addr)))
                            (do
                              (println 1 (byte->int16 (take 2 @code)))
                              (var-set code (nthrest @code 2))
                              (var-set addr (+ 3 @addr)))))

          #{:CALL_FCT
            :CALL_FCTX
            :CST_STR
            :IT_AS
            :LOAD
            :LOC
            :LOCX
            :STORE}     (do
                          (println (byte->uint8 (first @code)))
                          (var-set code (nthrest @code 1))
                          (var-set addr (inc @addr)))

          #{:CST_B}     (do
                          (println (byte->int8 (first @code)))
                          (var-set code (nthrest @code 1))
                          (var-set addr (inc @addr)))

          #{:CALL_OP
            :CALL_OPX}  (do
                          (println (byte->uint8 (first  @code))
                                   (byte->uint8 (second @code)))
                          (var-set code (nthrest @code 2))
                          (var-set addr (+ 2 @addr)))

          #{:PROC}      (dis
                          (println))
          (println))

        (var-set op_code (first @code))
        (var-set code    (rest  @code))
        (var-set addr    (inc   @addr))))))
