(ns toplas
  (:use [clojure.test] :reload)
  (:use [selectscript.vm] :reload)
  (:use [selectscript.core] :reload)
  (:use [macross] :reload))


(run-tests)

(deftest listing_1
  (let [env (vm:init 100 100 -1)]
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
  (let [env (vm:init 100 100 -1)]
    (iss 714                "rslt = ( a=12; b=33; b*22-a; );                    ")
    (iss ["a" "b" "rslt"]   "print('variables in memory: ', mem());             ")
    (iss 120
         "fac = PROC(x)                                                         "
         "'Calculate factorial for a given x by looping.'                       "
         ":(                                                                    "
         "      counter = product = 1;                # var = LOOP (            "
         "      LOOP (                                #         IF (..,         "
         "          IF ( counter == x.loc,            #             EXIT ..,    "
         "      /*then*/ EXIT del(counter, product),  #             ..);        "
         "      /*else*/ counter = counter + 1 );     #       );                "
         "                                            #                         "
         "          product = product * counter;      # var = IF (..,..,..);    "
         "      );                                    #                         "
         "  );                                        # var = SELECT .. ;       "
         "fac(5);                                                               ")))
