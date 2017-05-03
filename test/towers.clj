(ns towers
  (:use [clojure.test]      :reload)
  (:use [selectscript.core] :reload-all)
  (:use [macross]           :reload-all)
  (:use [selectscript.vm]   :reload-all))

;(run-tests)

(deftest simple
  (let [env (vm:init 100 100 0)]
    (iss [[[0 2] [0 1] [2 1] [0 2] [1 0] [1 2] [0 2]]]
         "mov = PROC(frm, to, Tower) : (                            "
         "      IF( $Tower == None, EXIT None);                     "
         "                                                          "
         "      IF( not $Tower[$frm], EXIT None);                   "
         "                                                          "
         "      IF( $Tower[$to],                                    "
         "          IF( $Tower[$frm][-1] > $Tower[$to][-1],         "
         "               EXIT None));                               "
         "                                                          "
         "       $Tower[$to]@+( $Tower[$frm][-1] );                 "
         "       $Tower[$frm]@pop();                                "
         "       $Tower;                                            "
         ");                                                        "
         "                                                          "
         "tower = [[3,2,1], [], []];                                "
         "moves = [[0,1], [0,2], [1,0], [1,2], [2,0], [2,1]];       "
         "                                                          "
         "finish = [[], [], [3,2,1]];                               "
         "                                                          "
         "select [$m1, $m2, $m3, $m4, $m5, $m6, $m7]                "
         "  from m1:moves, m2:moves, m3:moves, m4:moves,            "
         "       m5:moves, m6:moves, m7:moves                       "
         " where finish == mov($m7[0], $m7[1],                      "
         "                 mov($m6[0], $m6[1],                      "
         "                 mov($m5[0], $m5[1],                      "
         "                 mov($m4[0], $m4[1],                      "
         "                 mov($m3[0], $m3[1],                      "
         "                 mov($m2[0], $m2[1],                      "
         "                 mov($m1[0], $m1[1], tower)))))))         "
         "     as list;                                             ")
    (vm:exit env)))

(deftest simple_recursion
  (let [env (vm:init 100 100 0)]
    (iss [[[0 2] [0 1] [2 1] [0 2] [1 0] [1 2] [0 2]]]
         "mov = PROC(Tower, frm, to) : (                            "
         "      IF( $Tower == None, EXIT None);                     "
         "                                                          "
         "      IF( not $Tower[$frm], EXIT None);                   "
         "                                                          "
         "      IF( $Tower[$to],                                    "
         "          IF( $Tower[$frm][-1] > $Tower[$to][-1],         "
         "               EXIT None));                               "
         "                                                          "
         "       $Tower[$to]@+( $Tower[$frm][-1] );                 "
         "       $Tower[$frm]@pop();                                "
         "       $Tower;                                            "
         ");                                                        "
         "                                                          "
         "tower = [[3,2,1], [], []];                                "
         "moves = [[0,1], [0,2], [1,0], [1,2], [2,0], [2,1]];       "
         "                                                          "
         "finish = [[], [], [3,2,1]];                               "
         "                                                          "
         "    SELECT $m                                             "
         "      FROM m:moves                                        "
         "     WHERE finish == mov($tower, $m[0], $m[1])            "
         "START WITH $tower = tower                                 "
         "CONNECT BY $tower@mov($m[0], $m[1])                       "
         " STOP WITH $tower == None OR $step$ > 6                   "
         "         AS LIST;                                         ")
    (vm:exit env)))


(deftest no_cycle
  (let [env (vm:init 100 100 0)]
    (iss [[[[3 2 1] []    []]
           [[3 2]   []    [1]]
           [[3]     [2]   [1]]
           [[3]     [2 1] []]
           [[]      [2 1] [3]]
           [[1]     [2]   [3]]
           [[1]     []    [3 2]]]]
         "mov = PROC(Tower, frm, to) : (                            "
         "      IF( $Tower == None, EXIT None);                     "
         "                                                          "
         "      IF( not $Tower[$frm], EXIT None);                   "
         "                                                          "
         "      IF( $Tower[$to],                                    "
         "          IF( $Tower[$frm][-1] > $Tower[$to][-1],         "
         "               EXIT None));                               "
         "                                                          "
         "       $Tower[$to]@+( $Tower[$frm][-1] );                 "
         "       $Tower[$frm]@pop();                                "
         "       $Tower;                                            "
         ");                                                        "
         "                                                          "
         "tower = [[3,2,1], [], []];                                "
         "moves = [[0,1], [0,2], [1,0], [1,2], [2,0], [2,1]];       "
         "                                                          "
         "finish = [[], [], [3,2,1]];                               "
         "                                                          "
         "    SELECT $tower                                         "
         "      FROM m:moves                                        "
         "     WHERE finish == mov($tower, $m[0], $m[1])            "
         "START WITH $tower = tower                                 "
         "CONNECT BY NO CYCLE                                       "
         "           $tower@mov($m[0], $m[1])                       "
         " STOP WITH $tower == None OR $step$ > 6                   "
         "         AS LIST;                                         ")
    (vm:exit env)))


(deftest unique
  (let [env (vm:init 100 100 0)]
    (iss [[0  [[4,3,2,1], [],      []],      [0,1],
           1  [[4,3,2],   [1],     []],      [0,2],
           2  [[4,3],     [1],     [2]],     [1,2],
           3  [[4,3],     [],      [2,1]],   [0,1],
           4  [[4],       [3],     [2,1]],   [2,0],
           5  [[4,1],     [3],     [2]],     [2,1],
           6  [[4,1],     [3,2],   []],      [0,1],
           7  [[4],       [3,2,1], []],      [0,2],
           8  [[],        [3,2,1], [4]],     [1,2],
           9  [[],        [3,2],   [4,1]],   [1,0],
           10 [[2],       [3],     [4,1]],   [2,0],
           11 [[2,1],     [3],     [4]],     [1,2],
           12 [[2,1],     [],      [4,3]],   [0,1],
           13 [[2],       [1],     [4,3]],   [0,2],
           14 [[],        [1],     [4,3,2]], [1,2]]]
         "mov = PROC(Tower, frm, to) : (                            "
         "      IF( $Tower == None, EXIT None);                     "
         "                                                          "
         "      IF( not $Tower[$frm], EXIT None);                   "
         "                                                          "
         "      IF( $Tower[$to],                                    "
         "          IF( $Tower[$frm][-1] > $Tower[$to][-1],         "
         "               EXIT None));                               "
         "                                                          "
         "       $Tower[$to]@+( $Tower[$frm][-1] );                 "
         "       $Tower[$frm]@pop();                                "
         "       $Tower;                                            "
         ");                                                        "
         "                                                          "
         "tower = [[4,3,2,1], [], []];                              "
         "moves = [[0,1], [0,2], [1,0], [1,2], [2,0], [2,1]];       "
         "                                                          "
         "finish = [[], [], [4,3,2,1]];                             "
         "                                                          "
         "    SELECT $step$, $tower, $m                              "
         "      FROM m:moves                                        "
         "     WHERE finish == mov($tower, $m[0], $m[1])            "
         "START WITH $tower = tower                                 "
         "CONNECT BY UNIQUE                                         "
         "           $tower@mov($m[0], $m[1])                       "
         " STOP WITH $tower == None OR $step$ > 14                  "
         "         AS LIST;                                         ")
    (vm:exit env)))
