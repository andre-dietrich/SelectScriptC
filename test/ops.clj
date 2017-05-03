(ns ops
  (:use [clojure.test] :reload)
  (:use [selectscript.vm] :reload)
  (:use [selectscript.core] :reload)
  (:use [macross] :reload))

;(run-tests)

(deftest negative
  (let [env (vm:init 100 100 0)]
    (iss  22    "a=22;  ")
    (iss -22    "a=-a;  ")
    (iss  22    "a=-a;  ")
    (iss  22.2  "a=22.2;")
    (iss -22.2  "a=-a;  ")
    (iss  22.2  "a=-a;  ")
    (vm:exit env)))


(deftest addition
  (let [env (vm:init 100 100 0)]
    (iss  23          "a=22; a=a+1;   ")
    (iss  "abc23"     "a='abc' + a;   ")
    (iss 23.5         "a=22; a=a+1.5; ")
    (iss [1,2]        "a=[1]; a=a+2;  ")
    (iss [1,2,1,2]    "a=a+*a;        ")
    (iss [1,2,1,2,
          [1,2,1,2]]  "a=a+a;         ")
    (iss [22,1,2,1,2,
           [1,2,1,2]] "a=22+a;        ")
    (iss #{1 2}       "a={1}; a=a+2;  ")
    (iss #{1 2}       "a=a+2;         ")
    (iss #{1 2 3}     "a=a+3;         ")
    (vm:exit env)))

(deftest substitution
  (let [env (vm:init 100 100 0)]
    (iss  21    "a=22;    a=a-1; ")
    (iss  21.0  "a=22.0;  a=a-1; ")
    (iss -23    "a=-22;   a=a-1; ")
    (iss -23.0  "a=-22.0; a=a-1; ")
    (iss  21    "a=22;    a=a-True; ")
    (iss  21.0  "a=22.0;  a=a-True; ")
    (vm:exit env)))


(deftest multiplication
  (let [env (vm:init 100 100 0)]
    (iss        44    "a=22; a=a*2;     ")
    (iss        11.0  "a=22; a=a*0.5;   ")
    (iss           0  "a=22; a=a*False; ")
    (iss          ""  "a='abc'; a*0;    ")
    (iss       "abc"  "a='abc'; a*1;    ")
    (iss    "abcabc"  "a='abc'; a*2;    ")
    (iss "abcabcabc"  "a='abc'; a*3;    ")
    (iss          []  "a=[1,2,3]; a*0;  ")
    (iss     [1 2 3]  "a=[1,2,3]; a*1;  ")
    (iss [33 2 3 33
          2 3 33 2 3] "a=[33,2,3]; a*3; ")
    (vm:exit env)))


(deftest division
  (let [env (vm:init 100 100 0)]
    (iss  11   "a=22;  a/2;   ")
    (iss  44.0 "a=22;  a/0.5; ")
    (iss -11   "a=-22; a/2;   ")
    (iss -44.0  "a=-22; a/0.5; ")
    (vm:exit env)))


(deftest modulo
  (let [env (vm:init 100 100 0)]
    (iss  0  "a=22;  a % 2; ")
    (iss  1  "a=22;  a % 3; ")
    (iss  1  "a=22.; a % 3; ")
    (vm:exit env)))


(deftest power
  (let [env (vm:init 100 100 0)]
    (iss   2   "a=2; ")
    (iss   1.0 "a**0;")
    (iss   2   "a**1;")
    (iss   4   "a**2;")
    (iss 256   "a**8;")

    (iss 0.5      "a**-1;")
    (iss 0.003906 "a**-8;")

    (iss   2.0  "a=2.;")
    (iss   1.0  "a**0;")
    (iss   2.0  "a**1;")
    (iss   4.0  "a**2;")
    (iss 256.0  "a**8;")

    (iss 0.5      "a**-1;")
    (iss 0.003906 "a**-8;")

    (iss 1.414222 "a** 0.5;")
    (iss 2.828460 "a** 1.5;")
    (iss 0.353555 "a**-1.5;")
    (iss 0.707111 "a**-0.5;")
    (vm:exit env)))

(deftest AND
  (let [env (vm:init 100 100 0)]
    (iss true  "true  and true; ")
    (iss false "false and true; ")
    (iss false "true  and false;")
    (iss false "false and false;")

    (iss nil   "true  and none; ")
    (iss false "false and none;")
    (vm:exit env)))

(deftest OR
  (let [env (vm:init 100 100 0)]
    (iss true  "true  or true; ")
    (iss true  "false or true; ")
    (iss true  "true  or false;")
    (iss false "false or false;")

    (iss true  "true  or none; ")
    (iss nil   "false or none; ")
    (vm:exit env)))

(deftest XOR
  (let [env (vm:init 100 100 0)]
    (iss false "true  xor true; ")
    (iss true  "false xor true; ")
    (iss true  "true  xor false;")
    (iss false "false xor false;")

    (iss nil   "true  xor none; ")
    (iss nil   "false xor none; ")
    (vm:exit env)))


(deftest NOT
  (let [env (vm:init 100 100 0)]
    (iss false "not true; ")
    (iss true  "not false;")
    (iss nil   "not none; ")
    (vm:exit env)))


(deftest EQ
  (let [env (vm:init 100 100 0)]
    (iss true  "None == None; ")
    (iss true  "2    == 2;    ")
    (iss true  "2    == 2.0;  ")
    (iss false "2    == 2.1;  ")
    (iss true  "1    == True; ")

    (iss false "2    == '2';  ")
    (iss false "2    == '2.0';")

    (iss true  "[1,2] == [1,2];  ")
    (iss false "[1,2] == [1,2,3];")
    (iss false "[1,2] == [2,1];  ")

    (iss false "[1,2] == None;   ")

    (iss true  "{1,2} == {1,2};  ")
    (iss true  "{1,2} == {2,1};  ")
    (iss false "{1,2} == {1,2,3};")
    (vm:exit env)))

(deftest LT
  (let [env (vm:init 100 100 0)]
    (iss false "None < None; ")
    (iss false "2    < 2;    ")
    (iss false "2    < 2.0;  ")
    (iss true  "2    < 2.1;  ")
    (iss false "True < 1.0;  ")
    ;(iss false "2    < '2';  ")
    ;(iss false "2    < '2.0';")

    (iss false "[1,2] < [1,2];  ")
    (iss true  "[1,2] < [1,2,3];")
    (iss true  "[1,2] < [2,1];  ")
    (iss true  "[1,2] < [2,2];  ")
    (iss false "[1,2] < None;   ")

    (iss false  "{1,2} < {1,3};  ")
    (iss false  "{1,3} < {1,2};  ")
    (iss true   "{1,2} < {1,2,3};")
    (iss false  "{1,2,3} < {1,2};")
    (vm:exit env)))


(deftest GT
  (let [env (vm:init 100 100 0)]
    (iss false "None > None; ")
    (iss false "2    > 2;    ")
    (iss false "2    > 2.0;  ")
    (iss true  "2.1  > 2;    ")
    (iss false "True > 1.0;  ")
    ;(iss false "2    < '2';  ")
    ;(iss false "2    < '2.0';")

    (iss false "[1,2] > [1,2];  ")
    (iss true  "[1,2,3] > [1,2];")
    (iss false "[1,2] > [2,1];  ")
    (iss true  "[2,2] > [1,2];  ")
    (iss true  "[1,2] > None;   ")

    (iss false  "{1,3} > {1,2};  ")
    (iss false  "{1,2} > {1,3};  ")
    (iss true   "{1,2,3} > {1,2};")
    (iss false  "{1,2} > {1,2,3};")
    (vm:exit env)))

(deftest IN
  (let [env (vm:init 100 100 0)]
    (iss true  "a=[2,3,1]; 3 in a;")
    (iss false "55 in a;")

    (iss true  "a={2,3,1}; 3 in a;")
    (iss false "55 in a;")
    (vm:exit env)))


(deftest IAND
  (let [env (vm:init 100 100 0)]
    (iss 8    "12&9; ")
    (iss 4    "12&6; ")
    (vm:exit env)))


(deftest IOR
  (let [env (vm:init 100 100 0)]
    (iss 111 "11|100;")
    (iss 203 "11|200;")
    (vm:exit env)))


(deftest IXOR
  (let [env (vm:init 100 100 0)]
    (iss 110 "11^101;")
    (iss 194 "11^201;")
    (vm:exit env)))


(deftest INV
  (let [env (vm:init 100 100 0)]
    (iss -12 "~11; ")
    (iss   1 "~-2;")
    (vm:exit env)))


(deftest SHIFT
  (let [env (vm:init 100 100 0)]
    (iss 2048 "1<<11; ")
    (iss    1 "2048>>11;")
    (vm:exit env)))
