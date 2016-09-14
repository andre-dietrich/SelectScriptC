(ns selectscript.disassembler
    (:use [selectscript.utils] :reload)
    (:use [selectscript.compiler] :reload))

(declare dis
         dis:key
         dis:data
         dis:prog)


(defn dis [code]
  (let [[prog addr] (dis:data code 0)]
    (dis:prog prog addr)))

(defn dis:data [prog address]
  (println "DATA:" (byte->uint16 (take 2 prog)))

  (loop [words (byte->uint16 (take 2 prog))
         data  (nthrest prog 2)
         addr  (+ address 2)]
    (if (zero? words)
      [data addr]
      (let [new_data (loop [d data]
                       (print (char (first d)))
                       (if (= 0 (first d))
                         (do
                           (print ",")
                           (rest d))
                         (recur (rest d))))]
        (recur (dec words) new_data (inc addr))))))

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
            (var-set op_code (dis:key (+ @op_code 255)))
            (print (format "%-5d%-12s|P" @addr @op_code)))
          (do
            (var-set op_code (dis:key @op_code))
            (print (format "%-5d%-14s" @addr (str @op_code)))))
        (condp contains? @op_code
          #{:CST_LST
            :CST_SET}   (do
                          (println (byte->uint16 (take 2 @code)))
                          (var-set code (nthrest @code 2))
                          (var-set addr (+ @addr 2)))

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
          #{:IT_AS
            :LOAD
            :LOC}       (do
                          (println (byte->uint8 (first @code)))
                          (var-set code (nthrest @code 1))
                          (var-set addr (inc @addr)))
          #{:CST_B}     (do
                          (println (byte->int8 (first @code)))
                          (var-set code (nthrest @code 1))
                          (var-set addr (inc @addr)))
          (println))
        (var-set op_code (first @code))
        (var-set code    (rest  @code))
        (var-set addr    (inc   @addr))))))

(dis [2 0 97 0 0 3 3 15 0 14 1 0 29 30 24 12 0 34 7 4 35 24 5 0 25 -12 -1 12 0 0 33 24 9 0 27 1 38 2 25 -9 -1 0 0])

(dis [1 0 97 0 3 7 12 14 1 0 0])
;(byte->uint16 [2 0])
