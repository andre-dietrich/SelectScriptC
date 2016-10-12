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

  (:require [clojure.tools.cli      :refer  [parse-opts]]
            [clojure.data.json      :as json]
            [clojure.string         :as s])
  (:import  [org.webbitserver WebServer WebServers WebSocketHandler]
            [org.webbitserver.handler StaticFileHandler])

  (:gen-class :main true))

(declare cli-options
         ss:execute
         ss:compile
         ss:repl
         ss:server)


(def cli-options
  ;; An option with a required argument
  [["-o" "--output FILE" "Export result to file"        :default ""     :id :output]
   [nil  "--no-optimize" "Do not optimize"              :default true   :id :optimize   :assoc-fn (fn [m k _] (update-in m [k] not))]
   ["-d" "--debug"       "execute stepwise"             :default false  :assoc-fn (fn [m k _] (update-in m [k] not))]
   ["-a" "--assembly"    "print assembly"               :default false  :assoc-fn (fn [m k _] (update-in m [k] not))]
   ["-i" "--interim"     "print interim"                :default false  :assoc-fn (fn [m k _] (update-in m [k] not))]
   ["-b" "--bytecode"    "print bytecode"               :default false  :assoc-fn (fn [m k _] (update-in m [k] not))]
   ["-p" "--parse-tree"  "print parsetree"              :default false  :assoc-fn (fn [m k _] (update-in m [k] not))]
   ["-x" "--execute"     "Run the program"              :default false  :assoc-fn (fn [m k _] (update-in m [k] not))]
   ["-r" "--repl"        "interactive"                  :default false  :assoc-fn (fn [m k _] (update-in m [k] not))]
   ["-s" "--server"     "run compiler as web-server"    :default false  :assoc-fn (fn [m k _] (update-in m [k] not))]
   [nil  "--port"       "server port"                   :default 8080   :parse-fn #(Integer/parseInt %)]
   ;; A boolean option defaulting to nil
   ["-h" "--help"]])

(defn -main [& args]
  (binding [*out* *err*]
    (println    "  __      _           _   __           _       _   \n"
                "/ _\\ ___| | ___  ___| |_/ _\\ ___ _ __(_)_ __ | |_ \n"
                "\\ \\ / _ \\ |/ _ \\/ __| __\\ \\ / __| '__| | '_ \\| __|\n"
                "_\\ \\  __/ |  __/ (__| |__\\ \\ (__| |  | | |_) | |_ \n"
                "\\__/\\___|_|\\___|\\___|\\__\\__/\\___|_|  |_| .__/ \\__|\n"
                "                                       |_|        \n"))

  (let [{:keys [options arguments errors summary]} (parse-opts args cli-options)]
    (if (:help options)
      (println summary)
      (if (:repl options)
        (ss:repl (:optimize options))
        (if (:server options)
          (ss:server (:port options))
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
                  (loop [b @code]
                    (if (not-empty b)
                      (do
                        (print (format "%d, " (first b)))
                        (recur (rest b)))
                      (println)))))
              (if (:debug options)
                (let [env (vm:init 100 100 1) prog (vm:prog @code)]
                  (loop [status 0]
                    (if (zero? status)
                      (do
                        (read-line)
                        (recur (vm:exec env prog 1)))))
                  (println "RESULT:" (vm:rslt env))))

              (if (:execute options)
                (ss:execute @code false)))))))))

(defn on-message [connection message]
  (let [bytecode (str (list (ss:compile message true)))]
    (.send connection (subs bytecode 2 (- (count bytecode) 2)))))


(defn ss:server [port]
  (println (format "Starting server at localhost:%d\n" port))
  (doto (WebServers/createWebServer port)
    (.add "/"
          (proxy [WebSocketHandler] []
            (onOpen    [c]   (println "opened" c))
            (onClose   [c]   (println "closed" c))
            (onMessage [c j] (on-message c j))))
    (.add (StaticFileHandler. "."))
    (.start)))


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
   (let [env (vm:init 100 100 (if debug 1 0)) prog (vm:prog code)]
     (loop [status 0]
       (if (zero? status)
         (recur (vm:exec env prog (if debug 1 0)))))
     (println "RESULT:" (vm:rslt env)))))

(defn ss:exec
  ([code op] (ss:exec (vm:init 100 10 0) code op))
  ([env code op] (do (vm:exec env (vm:prog (ss:compile code op)) 0)
                     (vm:rslt env))))
