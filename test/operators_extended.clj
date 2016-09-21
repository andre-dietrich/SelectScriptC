(ns operators_extended
  (:use [clojure.test] :reload)
  (:use [selectscript.vm] :reload)
  (:use [selectscript.core] :reload)
  (:use [macross] :reload))

;(run-tests)

(deftest positive
  (let [env (vm:init 100 100 -1)]
    (iss  [1,2,3,4,5]           "a=[1,2,3,4,5]; ")
    (iss  15                    "+(*a);         ")
    (iss  16                    "+(*a,1);       ")
    (iss  17                    "+(1,*a,1);     ")
    (iss  [1,2,3,4,5,1]         "+(a,1);        ")
    (iss  [1,1,2,3,4,5,1]       "+(1,a,1);      ")
    (iss  [1,1,2,3,4,5,"str"]   "+(1,a,'str');  ")
    (iss  "16str"               "+(*a,1,'str'); ")

    (iss  [1,2,3,4,5,6]         "a@+(6);        ")
    (iss  [1,2,3,4,5,6,"str"]   "a@+('str');    ")))

(deftest negative
  (let [env (vm:init 100 100 -1)]
    (iss  [1,2,3,4,5]           "a=[1,2,3,4,5]; ")
    (iss  -13                   "-(*a);         ")
    (iss   85                   "-(100,*a);     ")
    (iss    0                   "-(100,*a,85);  ")

    (iss  #{1 2 3 4 5}          "a={1,2,3,4,5}; ")
    (iss  #{2 3 4 5}            "-(a,1);        ")
    (iss  #{2 3 4 5}            "a@-(1);        ")))

(deftest star
  (let [env (vm:init 100 100 -1)]
    (iss  [1 2 3 4 5]           "a=[1,2,3,4,5]; ")
    (iss  120                   "*(*a);         ")
    (iss  1200                  "*(10,*a);      ")
    ;(iss  2400                  "*(10,*a,2.0);  ")

    (iss  [1,2,3,4,5,1,2,
           3,4,5,1,2,3,4,
           5,1,2,3,4,5]         "*(2,a,2);      ")
    (iss  [1,2,3,4,5,1,2,
           3,4,5,1,2,3,4,
           5,1,2,3,4,5]         "a@*(4);        ")))

(deftest not_equal
  (let [env (vm:init 100 100 -1)]
    (iss [1 2 3 4 5]    "a=[1,2,3,4,5]; ")
    (iss true           "!=(*a);        ")
    (iss true           "!=(*a,a);      ")))
    ;(iss false          "!=(*a,a,*a);   ")))
