(ns macross
  (:use [clojure.test :only (deftest is run-tests)]))


(def optimize false)

(defmacro iss [rslt & code]
  (list 'is (list '= rslt (list 'ss:exec 'env (clojure.string/join "\n" code) 'optimize))))
