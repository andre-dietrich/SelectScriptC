(ns recur
  (:use [clojure.test]      :reload)
  (:use [selectscript.core] :reload-all)
  (:use [macross]           :reload-all)
  (:use [selectscript.vm]   :reload-all))

;(run-tests)

(deftest fak
  (let [env (vm:init 100 100 0)]
    (iss  22  "fak = proc(x, rslt:1)                                        "
              "      : IF ($x, recur($x-1, $rslt*$x), $rslt);               "
              "22;                                                          ")
    (iss  1   "fak(0);")
    (iss  1   "fak(1);")
    (iss  2   "fak(2);")
    (iss  6   "fak(3);")
    (iss  24  "fak(4);")
    (iss  120 "fak(5);")
    (iss  720 "fak(6);")))

(deftest ackermann
  (let [env (vm:init 100 100 0)]
    (iss  22  "A = PROC(m, n) : IF ( not $m,                                "
              "                      $n + 1,                                "
              "                      IF ( not $n,                           "
              "                           recur( $m - 1, 1),                "
              "                           recur( $m - 1, A($m, $n - 1))));  "
              "22;                                                          ")
    (iss   1  "A(0,0);")
    (iss   2  "A(1,0);")
    (iss   3  "A(2,0);")
    (iss   5  "A(3,0);")
    (iss   2  "A(0,1);")
    (iss   3  "A(1,1);")
    (iss   5  "A(2,1);")
    (iss  13  "A(3,1);")
    (iss   3  "A(0,2);")
    (iss   4  "A(1,2);")
    (iss   7  "A(2,2);")
    (iss  29  "A(3,2);")
    (iss   4  "A(0,3);")
    (iss   5  "A(1,3);")
    (iss   9  "A(2,3);")
    (iss  61  "A(3,3);")
    (iss   5  "A(0,4);")
    (iss   6  "A(1,4);")
    (iss  11  "A(2,4);")
    (iss 125  "A(3,4);")
    (iss   6  "A(0,5);")
    (iss   7  "A(1,5);")
    (iss  13  "A(2,5);")
    (iss 253  "A(3,5);")
    (iss   7  "A(0,6);")
    (iss   8  "A(1,6);")
    (iss  15  "A(2,6);")
    (iss 509  "A(3,6);")))
