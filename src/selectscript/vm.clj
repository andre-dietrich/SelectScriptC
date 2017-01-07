(ns selectscript.vm
  (:import (com.sun.jna Function Pointer Memory))
  (:import (com.sun.jna.ptr PointerByReference)))

(declare vm:S2
         vm:init
         vm:prog
         vm:exec
         vm:rslt
         vm:size
         vm:status
         round
         rslt->clj)

;(System/setProperty "jna.library.path" "/home/andre/Workspace/Projects/gitlab/2SOS/runtime/")


(def init_ (Function/getFunction "S2" "vm_init"))
(def exec_ (Function/getFunction "S2" "vm_execute"))
(def stat_ (Function/getFunction "S2" "vm_ready"))
(def rslt_ (Function/getFunction "S2" "vm_get_rslt"))
(def size_ (Function/getFunction "S2" "vm_size"))


(defn vm:init
  ([] (vm:init 100 100 0))
  ([mem fct steps]
   (.invoke init_ Pointer (to-array [mem fct steps]))))


(defn vm:status [env]
  (.invoke stat_ Byte (to-array [env])))


(defn vm:exec
  ([env prog] (vm:exec env prog 0))
  ([env prog trace]
   (.invoke exec_ Byte (to-array (list env prog trace)))))


(defn vm:size [env]
  (.invoke size_ Integer (to-array [env])))


(defn vm:prog [code]
  (let [buf (new Memory (count code))]
    (loop [c code i 0]
      (if (empty? c)
        buf
        (do (.setByte buf i (let [x (first c)]
                              (if (< x 128)
                                x
                                (- 255 x))))
            (recur (rest c) (inc i)))))))


(defn vm:rslt [env]
  (rslt->clj (.invoke rslt_ Pointer (to-array [env]))))


(defn dyn [func ret & args]
  (let [f (Function/getFunction "S2" (name func))]
    (.invoke f ret (to-array args))))

(defn round [val len]
  (let [acc (Math/pow 10 len)]
    (/ (int (* (double val) acc)) acc)))

(defn rslt->clj [ptr]
  (case (dyn :dyn_type Byte ptr)
    0 nil
    1 (if (= 1 (dyn :dyn_get_bool Byte ptr))
        true
        false)
    3 (dyn :dyn_get_int Integer ptr)
    4 (round (dyn :dyn_get_float Float ptr) 6)
    5 (dyn :dyn_get_string String ptr)
    6 (for [i (range 0 (dyn :dyn_length Integer ptr))]
        (rslt->clj (dyn :dyn_list_get_ref Pointer ptr i)))
    7 (set (for [i (range 0 (dyn :dyn_length Integer ptr))]
             (rslt->clj (dyn :dyn_list_get_ref Pointer ptr i))))
    8 (into {} (for [i (range 0 (dyn :dyn_length Integer ptr))]
                 [(dyn :dyn_dict_get_i_key String ptr i)
                  (rslt->clj (dyn :dyn_dict_get_i_ref Pointer ptr i))]))
    9 "PROC"))
