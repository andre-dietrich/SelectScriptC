(ns select
  (:use [clojure.test] :reload)
  (:use [selectscript.vm] :reload)
  (:use [selectscript.core] :reload)
  (:use [macross] :reload))


;(run-tests)

(deftest simple_select
  (let [env (vm:init 100 100 0)]
    (iss [0 1 2]        "SELECT $     FROM [0,1,2] AS list;")
    (iss 0              "SELECT $     FROM [0,1,2] AS val; ")
    (iss {"r" [0 1 2]}  "SELECT r:$   FROM [0,1,2] AS dict;")))

(deftest simple_select2
  (let [env (vm:init 100 100 0)]
    (iss [0 1 2 3 4 5 6 7 8 9]
         "a = [0,1,2,3,4,5,6,7,8,9];")
    (iss [4 5 6 7 8 9]
         "SELECT $ FROM a WHERE $>3 AS list;")
    (iss [4 6 8]
         "SELECT $              "
         "  FROM a              "
         " WHERE $>3 AND $%2==0 "
         "    AS list;          ")
    (iss [[9 0] [8 1] [7 2] [6 3] [5 4]
          [4 5] [3 6] [2 7] [1 8] [0 9]]
         "SELECT [a$, b$]     "
         "  FROM a, b:a       "
         " WHERE a$+b$==9     "
         "    AS list;        ")))

(deftest simple_dict
  (let [env (vm:init 100 100 0)]
    (iss [0 1 2 3 4]
         "a = [0,1,2,3,4];")
    (iss {"a" [0 1 2 3 4 0 1 2 3 4 0 1 2 3 4 0 1 2 3 4 0 1 2 3 4]
          "b" [0 0 0 0 0 1 1 1 1 1 2 2 2 2 2 3 3 3 3 3 4 4 4 4 4]}
         "c = SELECT a$, b$ FROM a, b:a AS dict;")
    (iss [[0 0] [1 1] [2 2] [3 3] [4 4]]
         "SELECT [$['a'], $['b']]   "
         "  FROM c                  "
         " WHERE $['a']==$['b']     "
         "    AS list;              ")))

(deftest simple_void
  (let [env (vm:init 100 100 0)]
    (iss 0  "a = 0;")
    (iss 5  "SELECT a=a+1 FROM [1,2,3,4,5,6,7,8,9] WHERE $>4 AS void;")
    (iss 5  "a;")))

(deftest simple_order
  (let [env (vm:init 100 100 0)]
    (iss [0 1 2 3 4]  "a = [0,1,2,3,4];")
    (iss [0 1 2 3 4]  "SELECT $ FROM a ORDER BY $ AS list;")
    (iss [0 1 2 3 4]  "SELECT $ FROM a ORDER BY $ ASC AS list;")
    (iss [4 3 2 1 0]  "SELECT $ FROM a ORDER BY $ DESC AS list;")
    (iss [[4 0 4] [0 4 4] [3 0 3]
          [0 3 3] [2 0 2] [0 2 2]
          [1 0 1] [0 1 1] [0 0 0]]
         "  SELECT [a$, b$, c$]        "
         "    FROM a, b:a, c:a         "
         "   WHERE a$**2+b$**2==c$**2  "
         "ORDER BY c$ DESC             "
         "      AS list;               ")))

(deftest simple_order2
  (let [env (vm:init 100 100 0)]
    (iss [0,1,2,3,4]    "a = [0,1,2,3,4];")
    (iss { "0" [[0 0 0]]
           "1" [[1 0 1] [0 1 1]]
           "4" [[4 0 4] [0 4 4]]
           "9" [[9 0 9] [0 9 9]]
          "16" [[16 0 16] [0 16 16]]}

         "  SELECT [a$**2, b$**2, c$**2]   "
         "    FROM a, b:a, c:a             "
         "   WHERE a$**2+b$**2==c$**2      "
         "GROUP BY c$**2                   "
         "       AS list;                  ")))

(deftest simple_limit
  (let [env (vm:init 100 100 0)]
    (iss (range 0 50)
         "a = [ 0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  "
         "     10, 11, 12, 13, 14, 15, 16, 17, 18, 19,  "
         "     20, 21, 22, 23, 24, 25, 26, 27, 28, 29,  "
         "     30, 31, 32, 33, 34, 35, 36, 37, 38, 39,  "
         "     40, 41, 42, 43, 44, 45, 46, 47, 48, 49]; ")
    (iss [0 1 2 3]
         "FROM a LIMIT 2+2 AS list;")
    (iss [21 22 23 24]
         "FROM a WHERE $>20 LIMIT 2+2 AS list;")
    (iss [3 2 1 0]
         "FROM a ORDER BY $ DESC LIMIT 4 AS list;")
    (iss {"" [0 1 2 3] "x" [1 2 3 4]}
         "SELECT $, x:$+1 FROM a LIMIT 4 AS dict;")))


(deftest nesting
  (let [env (vm:init 100 100 0)]
    (iss [["red" "green" "green" "red"] ["green" "red" "red" "green"]]
         "colors = ['red', 'green'];                                          "
         "neighbours = [[PROC:a$, PROC:b$], [PROC:a$, PROC:c$],   "
         "              [PROC:b$, PROC:d$], [PROC:c$, PROC:d$]];  "
         "                                                                    "
         "SELECT [a$, b$, c$, d$]                                 "
         "  FROM a:colors, b:colors, c:colors, d:colors           "
         " WHERE not (SELECT $                                    "
         "              FROM neighbours                           "
         "             WHERE $[0]() == $[1]()                     "
         "                AS list)                                "
         "    AS list;                                            ")))


(deftest select_val
  (let [env (vm:init 100 100 0)]
    (iss [0 1 2]    "a = [0,1,2];                       ")
    (iss 0          "SELECT $ FROM a AS val;            ")
    (iss 1          "SELECT $ FROM a WHERE $==1 AS val; ")
    (iss nil        "SELECT $ FROM a WHERE $==9 AS val; ")))
