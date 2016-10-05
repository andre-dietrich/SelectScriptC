(ns toplas
  (:use [clojure.test] :reload)
  (:use [selectscript.vm] :reload)
  (:use [selectscript.core] :reload)
  (:use [macross] :reload))


;(run-tests)

(deftest listing_1
  (let [env (vm:init 100 100 0)]
    (iss true
         "True OR False AND None;               ")
    (iss "2016 SelectScript"
         "int(63.5**2) / 2 + ' SelectScript';   ")
    (iss [nil false 33 1089 -22.2 ["ababab" #{3 4}]]
         "list_ = [None, False, 33, 33**2, -22.2, [ 'ab'*3, (3+{})+4 ]];        ")
    (iss #{1 2 3 5 "str" [22 33] [33 22]}
         "2set  = {1, 1, 2, 3, 5, 1, \"str\", [22,33], [22,33], [33,22], 5};    ")
    (iss {"a_1" 1, "a_2" [1 2 3], "a_3" ["ababab" #{3 4}]}
         "dict_ = {'a_1': 1, 'a_2': [1, 2, 3], a_3: list_[5]};                  ")
    (iss {"a_1" 1, "a_2" [1 2 3], "a_3" ["ababab", #{3 99}]}
         "dict_['a_3', 1, 1] = 99; dict_;")))

(deftest listing_2
  (let [env (vm:init 100 100 0)]
    (iss 714                "rslt = ( a=12; b=33; b*22-a; );                ")
    (iss ["a" "b" "rslt"]   "print('variables in memory: ', mem());         ")
    (iss 120
         "fac = PROC(x)                                                     "
         "'Calculate factorial for a given x by looping.'                   "
         ":(                                                                "
         "      counter = product = 1;                # var = LOOP (        "
         "      LOOP (                                #         IF (..,     "
         "          IF ( counter == x$,               #             EXIT ..,"
         "      /*then*/ EXIT del(counter, product),  #             ..);    "
         "      /*else*/ counter = counter + 1 );     #       );            "
         "                                            #                     "
         "          product = product * counter;      # var = IF (..,..,..);"
         "      );                                    #                     "
         "  );                                        # var = SELECT .. ;   "
         "fac(5);                                                           ")))

(deftest listing_3
  (let [env (vm:init 100 100 0)]
    (iss 714        "rslt = ( a$=12; b$=33; b$*22-a$; );                ")
    (iss ["rslt"]   "print('variables in memory: ', mem());             ")
    (iss 120        "fac2 = PROC(x)                                     "
                    "'Calculate factorial for given x with recursion.'  "
                    ": IF ( x$, x$ * fac2(x$ - 1), 1);                  "
                    "fac2(5); ")))


(deftest listing_4
  (let [env (vm:init 100 100 0)]
    (iss   {"dietrich" ["analogRead" "pinRead" "pinWrite"]
            "nardi"    ["analogRead" "pinRead"]
            "zug"      ["analogRead" "pinRead"]}

          "db_user = {id:   [    1     ,   2   ,    3   ],                  "
          "           name: ['dietrich', 'zug' , 'nardi'],                  "
          "           pass: ['pretty'  , 'c00l', 'sofar']};                 "
          "                                                                 "
          "db_func = [['analogRead', [3, 1, 2]], ['pinWrite', [1, 7, 9]],   "
          "           ['pinRead',    [1, 3, 2]], ['serial',   [2, 1, 5]]];  "
          "                                                                 "
          "db = SELECT func$[0]                                             "
          "       FROM db_user, func:db_func                                "
          "    # WHERE db_user$['id'] IN func$[1]                           "
          "      WHERE ( SELECT $                                           "
          "                FROM func$[1]                                    "
          "               WHERE db_user$['id'] == $                         "
          "                  AS list ) != []                                "
          "   ORDER BY func$[0] # ASC(ENDING) is default, or DESC(ENDING)   "
          "   GROUP BY db_user$['name']                                     "
          "      LIMIT 7                                                    "
          "         AS list;    # or AS void, value, list, set, dict        "
          "                                                                 ")))

(deftest listing_5
  (let [env (vm:init 100 100 0)]
    (iss    [1 2 3 4 5 6 7 8 9]
            "a = [1,2,3,4,5,6,7,8,9];   ")
    (iss    [1 2 4]
            "b = [0b1, 0o2, 0x4];       ")
    (iss    45
            "+(*a);                     ")
    (iss    602.37500
            "(*(*a))**0.5;              ")
    (iss    "52 <-- Result"
            "+(*a, *b, ' <-- Result');  ")
    (iss    true
            "<=(*a);")
    (iss    false
            "!=(1, *a);")))

(deftest listing_6
  (let [env (vm:init 100 100 0)]
    (iss    [10.1 11.3 10.899999 11.199999 15.399999 11.5 10.6 12.699999 12.8]
            "dist = [10.1,11.3,10.9,11.2,15.4,11.5,10.6,12.7,12.8];     ")
    (iss    [15.399999 12.699999 12.8]
            "Filter = FROM dist WHERE $ > 12;                           ")
    (iss    [10 11 10 11 15 11 10 12 12]
            "Map = SELECT int($) FROM dist;                             ")
    (iss    [nil 10.766667 11.133334 12.5 12.699999 12.5 11.599999 12.033332 nil]
            "MapEx = SELECT try( ($$(-1) + $ + $$(1)) / 3.0,            "
            "                    None )                                 "
            "          FROM dist;                                       ")
    (iss    11.833333
            "Reduce = (SELECT sum$@+($) FROM dist                       "
            "      START WITH sum$=0                                    "
            "              AS void) / len(dist);                        ")))


(deftest listing_7
  (let [env (vm:init 100 100 0)]
    (iss    [0 2046 4092 6138 8184]
            "analogRead = PROC(pin, res) : pin$ * res$;                    "
            "                                                              "
            "ir0 = {                                                       "
            "       pin:  0,                                               "
            "       res:  1023,                                            "
            "       init: PROC($, Pin, Res)                                "
            "             'Set basic sensor parameters Pin and Resolution.'"
            "             : ($.pin = Pin$; $.res = Res$;),                 "
            "       read: PROC($)                                          "
            "             'Read measurement'                               "
            "             : $.dist = $.lin(analogRead($.pin, $.res)),      "
            "       lin:  PROC($, volt)                                    "
            "             'Linearize measurement to cm...'                 "
            "             : cm$ = volt$ * 2                                "
            "      };                                                      "
            "                                                              "
            "ir1 = ir0; ir1.init(1, 1023);                                 "
            "ir2 = ir0; ir2.init(2, 1023);                                 "
            "ir3 = ir0; ir3.init(3, 1023);                                 "
            "ir4 = ir0; ir4.init(4, 1023);                                 "
            "                                                              "
            "ir_array = [ref ir0, ref ir1, ref ir2, ref ir3, ref ir4];     "
            "                                                              "
            "dist = select $.read() from ir_array;                         ")))
