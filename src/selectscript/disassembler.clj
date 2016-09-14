(ns selectscript.disassembler
    (:use [selectscript.utils] :reload)
    (:use [selectscript.compiler] :reload))

(declare dis
         dis:key
         dis:data
         dis:prog)


(defn dis
  ([code]           (dis code 0 ""))
  ([code addr tab]  (let [next (dis:data code addr tab)]
                      (dis:prog (first next) (second next) tab))))

(defn dis:data [prog address tab]
  (println tab "DATA:" (byte->uint16 (take 2 prog)))
  (print "" tab)
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

(defn dis:prog [prog address tab]
  (println)
  (println tab "PROGRAM:")
  (with-local-vars [op_code (first prog), code (rest prog), addr (inc address)]
    (while (not= nil @op_code)
      (do
        (if (< @op_code 0)
          (do
            (var-set op_code (dis:key (+ @op_code 128)))
            (print tab (format "%-5d%-14s" @addr (str @op_code "|P"))))
          (do
            (var-set op_code (dis:key @op_code))
            (print tab (format "%-5d%-14s" @addr (str @op_code)))))
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

(dis [3 0 100 105 115 116 0 0 77 97 112 69 120 0 3 3 15 0 14 1 0 29 12 0 0 30 24 40 0 3 40 1 26 0 7 -1 28 1 27 1 7 1 28 1 21 2 2 10 0 0 64 64 21 1 5 40 0 25 3 0 4 0 38 2 25 -40 -1 0 17 2 0])

;(dis [1 0 97 0 3 7 12 14 1 0 0])

;(dis [0 0 3 -121 12 7 23 0])

;(dis [0 0 3 7 -3 28 0])
;(dis [3 0 120 0 67 97 108 99 117 108 97 116 101 32 102 97 99 116 111 114 105 97 108 32 102 111 114 32 97 32 103 105 118 101 110 32 120 32 98 121 32 108 111 111 112 105 110 103 46 0 102 97 99 0 3 26 1 1 79 0 0 4 0 112 114 111 100 117 99 116 0 99 111 117 110 116 101 114 0 120 0 100 101 108 0 3 3 7 1 17 0 17 1 3 15 1 27 2 21 1 13 24 14 0 11 1 11 0 15 3 23 2 39 25 11 0 15 1 7 1 21 1 2 17 1 15 0 15 1 21 1 4 17 0 25 -39 -1 1 0 2 17 2 7 5 15 2 23 1 0])
;(byte->uint16 [2 0])
