(ns select
  (:use [clojure.test] :reload)
  (:use [selectscript.vm] :reload)
  (:use [selectscript.core] :reload)
  (:use [macross] :reload))


;(run-tests)

(deftest simple_select
  (let [env (vm:init 100 100 -1)]
    (iss [0 1 2]        "SELECT loc     FROM [0,1,2] AS list;")
    (iss 0              "SELECT loc     FROM [0,1,2] AS val; ")
    (iss {"r" [0 1 2]}  "SELECT r:loc   FROM [0,1,2] AS dict;")))

(deftest simple_select2
  (let [env (vm:init 100 100 -1)]
    (iss [0 1 2 3 4 5 6 7 8 9]
         "a = [0,1,2,3,4,5,6,7,8,9];")
    (iss [4 5 6 7 8 9]
         "SELECT loc FROM a WHERE loc>3 AS list;")
    (iss [4 6 8]
         "SELECT loc                "
         "  FROM a                  "
         " WHERE loc>3 AND loc%2==0 "
         "    AS list;              ")
    (iss [[9 0] [8 1] [7 2] [6 3] [5 4]
          [4 5] [3 6] [2 7] [1 8] [0 9]]
         "SELECT [a.loc, b.loc]     "
         "  FROM a, b:a             "
         " WHERE a.loc+b.loc==9     "
         "    AS list;              ")))

(deftest simple_dict
  (let [env (vm:init 100 100 -1)]
    (iss [0 1 2 3 4]
         "a = [0,1,2,3,4];")
    (iss {"a" [0 1 2 3 4 0 1 2 3 4 0 1 2 3 4 0 1 2 3 4 0 1 2 3 4]
          "b" [0 0 0 0 0 1 1 1 1 1 2 2 2 2 2 3 3 3 3 3 4 4 4 4 4]}
         "c = SELECT a.loc, b.loc FROM a, b:a AS dict;")
    (iss [[0 0] [1 1] [2 2] [3 3] [4 4]]
         "SELECT [loc['a'], loc['b']]   "
         "  FROM c                      "
         " WHERE loc['a']==loc['b']     "
         "    AS list;                  ")))

(deftest simple_void
  (let [env (vm:init 100 100 -1)]
    (iss 0  "a = 0;")
    (iss 5  "SELECT (a=a+1;) FROM [1,2,3,4,5,6,7,8,9] WHERE loc>4 AS void;")
    (iss 5  "a;")))

(deftest simple_order
  (let [env (vm:init 100 100 -1)]
    (iss [0 1 2 3 4]  "a = [0,1,2,3,4];")
    (iss [0 1 2 3 4]  "SELECT loc FROM a ORDER BY loc AS list;")
    (iss [0 1 2 3 4]  "SELECT loc FROM a ORDER BY loc ASC AS list;")
    (iss [4 3 2 1 0]  "SELECT loc FROM a ORDER BY loc DESC AS list;")
    (iss [[4 0 4] [0 4 4] [3 0 3]
          [0 3 3] [2 0 2] [0 2 2]
          [1 0 1] [0 1 1] [0 0 0]]
         "  SELECT [a.loc, b.loc, c.loc]        "
         "    FROM a, b:a, c:a                  "
         "   WHERE a.loc**2+b.loc**2==c.loc**2  "
         "ORDER BY c.loc DESC                   "
         "      AS list;                        ")))

(deftest simple_order
  (let [env (vm:init 100 100 -1)]
    (iss [0,1,2,3,4]    "a = [0,1,2,3,4];")
    (iss { "0" [[0 0 0]]
           "1" [[1 0 1] [0 1 1]]
           "4" [[4 0 4] [0 4 4]]
           "9" [[9 0 9] [0 9 9]]
          "16" [[16 0 16] [0 16 16]]}

         "  SELECT [a.loc**2, b.loc**2, c.loc**2]   "
         "    FROM a, b:a, c:a                      "
         "   WHERE a.loc**2+b.loc**2==c.loc**2      "
         "GROUP BY c.loc**2                         "
         "       AS list;                           ")))

(deftest simple_limit
  (let [env (vm:init 100 100 -1)]
    (iss (range 0 50)
         "a = [ 0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  "
         "     10, 11, 12, 13, 14, 15, 16, 17, 18, 19,  "
         "     20, 21, 22, 23, 24, 25, 26, 27, 28, 29,  "
         "     30, 31, 32, 33, 34, 35, 36, 37, 38, 39,  "
         "     40, 41, 42, 43, 44, 45, 46, 47, 48, 49]; ")
    (iss [0 1 2 3]
         "FROM a LIMIT 2+2 AS list;")
    (iss [21 22 23 24]
         "FROM a WHERE loc>20 LIMIT 2+2 AS list;")
    (iss [3 2 1 0]
         "FROM a ORDER BY loc DESC LIMIT 4 AS list;")
    (iss {"" [0 1 2 3] "x" [1 2 3 4]}
         "SELECT loc, x:loc+1 FROM a LIMIT 4 AS dict;")))


(deftest nesting
  (let [env (vm:init 100 100 -1)]
    (iss [["red" "green" "green" "red"] ["green" "red" "red" "green"]]
         "colors = ['red', 'green'];                                          "
         "neighbours = [[PROC:a.loc, PROC:b.loc], [PROC:a.loc, PROC:c.loc],   "
         "              [PROC:b.loc, PROC:d.loc], [PROC:c.loc, PROC:d.loc]];  "
         "                                                                    "
         "SELECT [a.loc, b.loc, c.loc, d.loc]                                 "
         "  FROM a:colors, b:colors, c:colors, d:colors                       "
         " WHERE not (SELECT loc                                              "
         "              FROM neighbours                                       "
         "             WHERE loc[0]() == loc[1]()                             "
         "                AS list)                                            "
         "    AS list;                                                        ")))


(deftest select_val
  (let [env (vm:init 100 100 -1)]
    (iss [0 1 2]    "a = [0,1,2];                           ")
    (iss 0          "SELECT loc FROM a AS val;              ")
    (iss 1          "SELECT loc FROM a WHERE loc==1 AS val; ")
    (iss nil        "SELECT loc FROM a WHERE loc==9 AS val; ")))
