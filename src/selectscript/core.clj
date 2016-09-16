(ns selectscript.core
    (:use [selectscript.parser          :only (parse)])
    (:use [selectscript.optimizer       :only (optimize)])
    (:use [selectscript.assembler       :only (assemble)])
    (:use [selectscript.compiler        :only (cmp)])
    (:use [selectscript.vm]             :reload)
    (:use [selectscript.disassembler    :only (dis)])

    (:require [clojure.tools.cli :refer [parse-opts]]))

(declare cli-options
         ss:execute
         ss:compile)


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

(defn -main [& args]
  (println "  ███████╗███████╗██╗     ███████╗ ██████╗████████╗███████╗ ██████╗██████╗ ██╗██████╗ ████████╗")
  (println "  ██╔════╝██╔════╝██║     ██╔════╝██╔════╝╚══██╔══╝██╔════╝██╔════╝██╔══██╗██║██╔══██╗╚══██╔══╝")
  (println "  ███████╗█████╗  ██║     █████╗  ██║        ██║   ███████╗██║     ██████╔╝██║██████╔╝   ██║   ")
  (println "  ╚════██║██╔══╝  ██║     ██╔══╝  ██║        ██║   ╚════██║██║     ██╔══██╗██║██╔═══╝    ██║   ")
  (println "  ███████║███████╗███████╗███████╗╚██████╗   ██║   ███████║╚██████╗██║  ██║██║██║        ██║   ")
  (println "  ╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝   ╚═╝   ╚══════╝ ╚═════╝╚═╝  ╚═╝╚═╝╚═╝        ╚═╝   ")
  (println)
  (let [{:keys [options arguments errors summary]} (parse-opts args cli-options)]
    (println options arguments errors summary)
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
        (println @code))
      (if (:debug options)
        (ss:execute @code true))
      (if (:execute options)
        (ss:execute @code false))
      (if (:repl options)
        (println "repl")))))

;(-main "-o" "test.bS2" "-d" "test.S2")

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
