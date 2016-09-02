(ns macross
  (:use [clojure.test] :reload))

(defmacro iss [rslt & code]
  (list 'is (list '= rslt (list 'ss:exec 'env (clojure.string/join "\n" code) 'optimize))))

(def optimize false)
