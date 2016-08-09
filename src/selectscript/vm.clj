(ns selectscript.vm
    (:import (com.sun.jna Function Pointer Memory))

    (:import (com.sun.jna.ptr PointerByReference)))



(System/setProperty "jna.library.path" "/home/andre/Workspace/Projects/gitlab/2SOS/runtime/")

(defn S2 [func ret & args]
  (let [f (Function/getFunction "2s" (name func))]
    (.invoke f ret (to-array args))))

(def env (S2 :vm_init Pointer 100 100 1))

;(println (S2 :vm_size Integer (.getValue env)))

;(S2 :vm_printf Void "fucking" 1)

(defn prog [code]
  (let [buf (new Memory (count code))]
    (loop [c code i 0]
      (if (empty? c)
        buf
        (do (.setByte buf i (first c))
            (recur (rest c) (inc i)))))))

(S2 :vm_execute Byte env (prog [0 0 3 7 12 0]) 10)


;(jna/invoke Integer s2/vm_init 10 10 1)
