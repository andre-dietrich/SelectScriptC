(ns exit
  (:use [clojure.test]      :reload)
  (:use [selectscript.core] :reload-all)
  (:use [macross]           :reload-all)
  (:use [selectscript.vm]   :reload-all))

;(run-tests)

(deftest exit1
  (let [env (vm:init 100 100 0)]
    (iss  22  "22;")
    (iss  -2  "-2;")
    (iss   4  "2+2;")
    (iss   1  "3-2;")
    (iss  -1  "2-3;")
    (iss  -5  "-3-2;")
    (iss   6  "3*2;")
    (iss 1.5  "3/2.;")
    (iss   8  "2**3;")
    (iss   1  "3%2;")))
