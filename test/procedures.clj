(ns procedures
  (:use [clojure.test] :reload)
  (:use [selectscript.vm] :reload)
  (:use [selectscript.core] :reload)
  (:use [macross] :reload))


(run-tests)

(deftest procedure_1
  (let [env (vm:init 100 100 -1)]
    (iss 1  "p = PROC: (a=a+b); "
            "a=1; b=1;          ")
    (iss 2  "p();               ")
    (iss 3  "p();               ")
    (iss 4  "p();               ")))

(deftest procedure_2
  (let [env (vm:init 100 100 -1)]
    (iss 1  "p = PROC: (a = 1; a=a+1;);"
            "a=1; b=1;                 ")
    (iss 2  "p();")
    (iss 2  "p();")
    (iss 2  "p();")))

(deftest procedure_3
  (let [env (vm:init 100 100 -1)]
    (iss 1  "p = PROC (a,b): a.loc + b.loc;"
            "a=1; b=1;")
    (iss 2  "p(a , b);    ")
    (iss 2  "p(1 , 1);    ")
    (iss 5  "p(2*a , 3*b);")

    (iss 4  "p = PROC (a,b): (a=22; a.loc + b.loc;);"
            "p(2 , 2);    ")
    (iss 22 "a;           ")))

(deftest procedure_4
  (let [env (vm:init 100 100 -1)]
    (iss 1  "p = PROC : ( b = PROC(a) : 3*a.loc;       "
            "             b(2)*b(3);              ); 1;")
    (iss 54 "p();    ")
    (iss 54 "p();    ")))

(deftest procedure_4
  (let [env (vm:init 100 100 -1)]
    (iss 1  "fak = PROC(x): if(x.loc,"
            "                  x.loc*fak(x.loc - 1),"
            "                  1); 1;")
    (iss   1  "fak(0);    ")
    (iss   1  "fak(1);    ")
    (iss   2  "fak(2);    ")
    (iss   6  "fak(3);    ")
    (iss  24  "fak(4);    ")
    (iss 120  "fak(5);    ")
    (iss 720  "fak(6);    ")))
