(ns selectscript.core
    (:use [selectscript.parser]         :reload)
    (:use [selectscript.optimizer]      :reload)
    (:use [selectscript.assembler]      :reload)
    (:use [selectscript.utils]          :reload)
    (:use [selectscript.compiler]       :reload)
    (:use [selectscript.vm]             :reload)
    (:use [selectscript.disassembler]   :reload))

;1, 0, 0, 3, 26, 0, 0, 13, 0, 1, 0, 98, 0, 3, 15, 0, 7, 2, 21, 1, 2, 2, 0
(assemble (parse "IF( False, False, True);"))
;(cmp (assemble (optimize (parse "{a:12};"))))
;(optimize (parse "[1,2,3];"))


(defn -main
  "I don't do a whole lot."
  [& args]
  (println "testing"))

(defn ss:compile [string opt]
  (as-> string input
    (parse input)
    (if opt
      (optimize input)
      input)
    (assemble input)
    (cmp input)))


(defn ss:execute [code]
  (let [env (vm:init 100 100 1)  prog (vm:prog code)]
    (loop [status 0]
      (if (zero? status)
        (recur (vm:exec env prog 1))))
    (println "RESULT:" (vm:rslt env))))

(defn ss:exec
  ([code op] (ss:exec (vm:init 100 10 -1) code op))
  ([env code op] (do (vm:exec env (vm:prog (ss:compile code op)) 0)
                     (vm:rslt env))))

;0, 0, 3, 3, 25, 255, 255, 1, 0
;(ss:exec "[1,2] < [1,2]; [1,2] < [1,2,3];" false)

;0, 0, 3, 3, 40, 1, 7, 0, 7, 1, 40, 0, 25, 4, 0, 7, 2, 0, 0


;(int16->byte -1)
;(def xxx (vm:prog (ss:compile "-2;" false)))
;(def env (vm:init 100 100 1))

;(vm:exec env  1)

;(ss:execute (ss:compile "-2.22;" false))
