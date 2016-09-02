(ns procedures
  (:use [clojure.test] :reload)
  (:use [selectscript.vm] :reload)
  (:use [selectscript.core] :reload)
  (:use [macross] :reload))


;(defmacro iss [rslt & code]
;  (list 'is (list '= rslt (list 'ss:exec 'env (clojure.string/join "\n" code) 'optimize))))

;(def optimize true)

;(println optimize)

;(run-tests)

; (deftest try_array
;   (let [env (vm:init 100 100 -1)]
;     (iss 1  "p = PROC: (a=a+b); "
;             "a=1; b=1;          ")
;     (iss 2  "p();               ")
;     (iss 3  "p();               ")
;     (iss 4  "p();               ")))
