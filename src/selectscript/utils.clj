(ns selectscript.utils
    (:import (com.sun.jna Pointer Memory)))

(declare byte->float
         byte->int32
         byte->int16
         byte->int8
         byte->string
         byte->uint32
         byte->uint16
         byte->uint8

         float->byte

         int32->byte
         int16->byte
         int8->byte

         string->byte

         uint32->byte
         uint16->byte
         uint8->byte)

(defn string->byte [string]
  (let [len (count string)]
    (let [buf (new Memory (inc len))]
      (.setString buf 0 string)
      (loop [bytes '() i len]
        (if (= i -1)
          bytes
          (recur (cons (.getByte buf i) bytes)
                 (dec i)))))))

(defn float->byte [val]
  (let [buf (new Memory 4)]
    (.setFloat buf 0 val)
    [(.getByte buf 0) (.getByte buf 1) (.getByte buf 2) (.getByte buf 3)]))

(defn byte->float [[b0 b1 b2 b3]]
  (let [buf (new Memory 4)]
    (.setByte buf 0 b0)
    (.setByte buf 1 b1)
    (.setByte buf 2 b2)
    (.setByte buf 3 b3)
    (.getFloat buf 0)))


(defn int32->byte [val]
  (let [buf (new Memory 4)]
    (.setInt buf 0 val)
    (list (.getByte buf 0)
          (.getByte buf 1)
          (.getByte buf 2)
          (.getByte buf 3))))


(defn byte->int32 [[b0 b1 b2 b3]]
  (let [buf (new Memory 4)]
    (.setByte buf 0 b0)
    (.setByte buf 1 b1)
    (.setByte buf 2 b2)
    (.setByte buf 3 b3)
    (.getInt buf 0)))


(defn int16->byte [val]
  (let [buf (new Memory 2)]
    (.setShort buf 0 val)
    [(.getByte buf 0) (.getByte buf 1)]))


(defn uint16->byte [val]
    (int16->byte (if (< val 0)
                   (+ val 32768)
                   val)))


(defn byte->int16 [[b0 b1]]
  (let [buf (new Memory 2)]
    (.setByte buf 0 b0)
    (.setByte buf 1 b1)
    (.getShort buf 0)))


(defn byte->uint16 [bytes]
    (let [val (byte->int16 bytes)]
      (if (> val 32768)
        (- val 2))))

(defn int8->byte [val]
  (let [buf (new Memory 1)]
    (.setByte buf 0 val)
    [(.getByte buf 0)]))

(defn uint8->byte [val]
  (int8->byte (if (< val 0)
                (+ 255 val)
                val)))

(defn byte->int8 [byte]
  (let [buf (new Memory 1)]
    (.setByte buf 0 byte)
    (.getByte buf 0)))

(defn byte->uint8 [byte]
  (+ 127 (byte->int8 byte)))
