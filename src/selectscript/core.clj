(ns selectscript.core
  (:use [selectscript.parser          :only (parse)]    :reload)
  (:use [selectscript.optimizer       :only (optimize)] :reload)
  (:use [selectscript.assembler       :only (assemble)] :reload)
  (:use [selectscript.compiler        :only (cmp)]      :reload)
  (:use [selectscript.vm              :only (vm:init
                                             vm:exec
                                             vm:prog
                                             vm:rslt)]  :reload)
  (:use [selectscript.disassembler    :only (dis)]      :reload)

  (:require [clojure.tools.cli :refer [parse-opts]])

  (:gen-class :main true))

(declare cli-options
         ss:execute
         ss:compile
         ss:repl)


(def cli-options
  ;; An option with a required argument
  [["-o" "--output FILE" "Export result to file"
    :id :output
    :default ""]
    ;:parse-fn #(Integer/parseInt %)
    ;:validate [#(< 0 % 0x10000) "Must be a number between 0 and 65536"]]
   [nil "--no-optimize" "Do not optimize"
    :id :optimize
    :default true
    :assoc-fn (fn [m k _] (update-in m [k] not))]
   ["-d" "--debug" "execute stepwise"
    :default false
    :assoc-fn (fn [m k _] (update-in m [k] not))]
   ;; A non-idempotent option
   ["-a" "--assembly" "print assembly"
    :default false
    :assoc-fn (fn [m k _] (update-in m [k] not))]
   ["-i" "--interim" "print interim"
    :default false
    :assoc-fn (fn [m k _] (update-in m [k] not))]
   ["-b" "--bytecode" "print bytecode"
    :default false
    :assoc-fn (fn [m k _] (update-in m [k] not))]
   ["-p" "--parse-tree" "print parsetree"
    :default false
    :assoc-fn (fn [m k _] (update-in m [k] not))]
   ["-x" "--execute" "Run the program"
    :default false
    :assoc-fn (fn [m k _] (update-in m [k] not))]
   ["-r" "--repl" "interactive"
    :default false
    :assoc-fn (fn [m k _] (update-in m [k] not))]
   ;; A boolean option defaulting to nil
   ["-h" "--help"]])

;     _          _                    _                _
;    | |        | |           _      | |              (_)      _
;    \ \   ____| | ____ ____| |_     \ \   ____  ____ _ ____ | |_
;     \ \ / _   |/ _   ___  _     \ \ / ___/ ___ |  _ \|  _]]
;  _____) | (/ /| ( (/ ( (___| |__ _____) | (___| |   | | | | | |__
;(______/ \____)_|\________\___|______/ \_____|   |_| ||_/ \___
;                                                      |_|]])


; __   ___       ___  __  ___  __   __   __     __  ___
;/__` |__  |    |__  /  `  |  /__` /  ` |__  | |__)  |
;.__/ |___ |___ |___ \__,  |  .__/ \__, |  \ | |     |


;"  __,      _          __,                     "
;" (        //      _/_(           o     _/_  "
;"  `.  _  // _  _, /   `.  _, _  , ,_   /    "
;"(___)(/_(/_(/_(__(__(___)(__/ _(_/|_)_(__   "
;"                                    |         "




(defn -main [& args]
  (println " o-o      o           o   o-o                   o ")
  (println "|         |           |  |              o       | ")
  (println " o-o  o-o | o-o  o-o -o-  o-o   o-o o-o   o-o  -o-")
  (println "    | |-' | |-' |     |      | |    |   | |  |  | ")
  (println "o--o  o-o o o-o  o-o  o  o--o   o-o o   | O-o   o ")
  (println "                                          |       ")
  (println "                                          o       ")
  (println)

  (let [{:keys [options arguments errors summary]} (parse-opts args cli-options)]
    (if (:help options)
      (println summary))

    (if (empty? arguments)
      (ss:repl (:optimize options))
      (with-local-vars [code (slurp (first arguments))]
        (var-set code (parse @code))
        (if (:optimize options)
          (var-set code (optimize @code)))
        (if (:parse-tree options)
          (println @code))
        (var-set code (assemble @code))
        (if (:interim options)
          (println @code))
        (var-set code (cmp @code))
        (if (:assembly options)
          (dis @code))
        (if (:bytecode options)
          (do
            (print "{")
            (loop [b @code]
              (if (not-empty b)
               (do
                 (print (format "%d, " (first b)))
                 (recur (rest b)))))
            (println "}")))
          ;(println @code))
        (if (:debug options)
        ;  (ss:execute @code true))
          (let [env (vm:init 100 100 1) prog (vm:prog @code)]
            (loop [status 0]
              (if (zero? status)
                (do
                  (read-line)
                  (recur (vm:exec env prog 1)))))
            (println "RESULT:" (vm:rslt env))))

        (if (:execute options)
          (ss:execute @code false))))
    (if (:repl options)
      (ss:repl (:optimize options)))))

;(-main "-o" "test.bS2" "-d" "test.S2")
;(optimize (parse "select k:1+2+c, b from a, b as dict;"))
;(parse "{a:1, b:2};")

(defn ss:repl [opt]
  (let [env (vm:init 100 100 -1)]
    (print ">>> ")
    (flush)
    (loop [code (read-line)]
      ;(println)
      (vm:exec env (vm:prog (ss:compile code opt)) 0)
      (print (vm:rslt env) "\n>>> ")
      (flush)
      (recur (read-line)))))

(defn ss:compile [string opt]
  (as-> string input
    (parse input)
    (if opt
      (optimize input)
      input)
    (assemble input)
    (cmp input)))


(defn ss:execute
  ([code]
   (ss:execute code false))
  ([code debug]
   (let [env (vm:init 100 100 (if debug 1 -1)) prog (vm:prog code)]
     (loop [status 0]
       (if (zero? status)
         (recur (vm:exec env prog (if debug 1 0)))))
     (println "RESULT:" (vm:rslt env)))))

(defn ss:exec
  ([code op] (ss:exec (vm:init 100 10 -1) code op))
  ([env code op] (do (vm:exec env (vm:prog (ss:compile code op)) 0)
                     (vm:rslt env))))
