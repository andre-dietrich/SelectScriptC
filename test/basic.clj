(ns basic
  (:use [clojure.test]      :reload)
  (:use [selectscript.vm]   :reload)
  (:use [selectscript.core] :reload)
  (:use [macross]           :reload))

;(run-tests)

(deftest math
  (let [env (vm:init 100 100 -1)]
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

(deftest comments
  (let [env (vm:init 100 100 -1)]
    (iss  1  "# line comments      "
             "1; # 2;              "
             "                     ")))
;    (iss  2  "# multiline comments "
;             "1;       /*          "
;             "2;                   "
;             "*/                   ")))

(deftest logical
  (let [env (vm:init 100 100 -1)]
    (iss  true   "true;          ")
    (iss  false  "false;         ")
    (iss  nil    "None;          ")
    (iss  false  "not true;      ")
    (iss  true   "not false;     ")
    (iss  nil    "not None;      ")
    (iss  true   "true and true; ")
    (iss  false  "false and true;")
    (iss  true   "True OR True;  ")
    (iss  true   "FALSE OR True; ")
    (iss  false  "True XOR True; ")))

(deftest comparison
  (let [env (vm:init 100 100 -1)]
    (iss  false  "1 > 2; ")
    (iss  true   "1 < 2; ")
    (iss  true   "2 >= 2;")
    (iss  true   "2 != 3;")
    (iss  false  "2 == 3;")))

(deftest precedence
  (let [env (vm:init 100 100 -1)]
    (iss  14    "2+3*4;  ")
    (iss  20    "(2+3)*4;")
    (iss  83    "2+3**4; ")
    (iss  true  "True OR False AND True;")))

(deftest array
  (let [env (vm:init 100 100 -1)]
    (iss '(11 22 33 44 55 66 77)
         "a=[11,22,33,44,55,66,77];")
    (iss 11 "a[0];")
    (iss 77 "a[6];")
    (iss '((11 22) (33 44) "abc")
         "b=[[11,22],[33,44],'abc'];")
    (iss '(11 22) "b[0];")
    (iss 11 "b[0,0];")
    (iss 44 "b[1,1];")
    (iss "abc" "b[2];")))

(deftest array2
  (let [env (vm:init 100 100 -1)]
    (iss '(1 2 3 (4 5 6 7))
         "a=[1,2,3,[4,5,6,7]];")
    (iss '(11 2 3 (4 5 6 7))
         "a[0]=11; a;")
    (iss '(11 6 3 (4 5 6 7))
         "a[1]=a[1]*a[2]; a;")
    (iss '(11 6 3 (99 5 6 7))
         "a[3,0]=99; a;")))

(deftest dict
  (let [env (vm:init 100 100 -1)]
    (iss {"a" 22, "b22" "test"}
         "a={'a':22, 'b22':'test'};")
    (iss    22  "a['a'];")
    (iss "test" "a['b22'];")))

(deftest dict2
  (let [env (vm:init 100 100 -1)]
    (iss {"a" 22, "b22" "test"}
         "a={'a':22, 'b22':'test'};")
   (iss {"a" 999, "b22" "test"}
        "a['a']=999; a;")
   (iss {"a" 999, "b22" [1 2 3 4]}
        "a['b22']=[1,2,3,4]; a;")))

(deftest dict3
  (let [env (vm:init 100 100 -1)]
    (iss {"a" 22, "b22" "test"}
         "a={'a':22, 'b22':'test'};")
    (iss {"a" 999, "b22" "test"}
         "a.a=999; a;")
    (iss {"a" 999, "b22" [1 2 3 4]}
         "a.b22=[1,2,3,4]; a;")))

(deftest SEQUENCE
  (let [env (vm:init 100 100 -1)]
    (iss 3  "a=(b=1; c=2; b+c;);")
    (iss 1  "b;")
    (iss 2  "c;")

    (iss 9  "(1;2;3;4+5;);")
    (iss 9  "(1;(1;4+5;););")))


(deftest IF
  (let [env (vm:init 100 100 -1)]
    (iss 0      "IF( 2==2, 0, 1);          ")
    (iss false  "IF( 2!=2, (0; 1;), False);")
    (iss 0      "IF( 2!=2, 1, (False; 0;));")
    (iss true   "IF( True );               ")
    (iss false  "IF( FALSE );              ")
    (iss false  "IF( True, False);         ")
    (iss true   "IF( False, False, True);  ")))

(deftest LOOP
  (let [env (vm:init 100 100 -1)]
    (iss  0 "i=0;")
    (iss 10 "LOOP( IF(i==10, EXIT i, i=i+1) );")
    (iss  1 "i = a = 1;")
    (iss 46 "LOOP( IF(i==10, EXIT a, (a=a+i; i=i+1;)));") == 46))


(deftest PRINT
  (let [env (vm:init 100 100 -1)]
    (iss 4   "print(2+2);             ")
    (iss "x" "print(2+2, True, \"x\");")))


(deftest DEL_MEM
  (let [env (vm:init 100 100 -1)]
    (iss 3               "a=1; b=2; c=3;")
    (iss ["a" "b" "c"]   "mem();        ")
    (iss 1               "del(a);       ")
    (iss false           "mem(a);       ")
    (iss ["c" "b"]       "mem();        ")
    (iss true            "mem('b');     ")
    (iss []              "del(); mem(); ")))
