(ns selectscript.core
  (:use [selectscript.parser          :only (parse)]    :reload)
  (:use [selectscript.optimizer       :only (optimize)] :reload)
  (:use [selectscript.assembler       :only (assemble)] :reload)
  (:use [selectscript.compiler        :only (cmp)]      :reload)
  (:use [selectscript.vm              :only (vm:status_codes
                                             vm:init
                                             vm:exec
                                             vm:prog
                                             vm:status
                                             vm:reset
                                             vm:rslt)]  :reload)
  (:use [selectscript.disassembler    :only (dis)]      :reload)

  (:require [clojure.term.colors :refer :all])

  (:require [clojure.tools.cli      :refer  [parse-opts]]
            [clojure.data.json      :as json]
            [clojure.string         :as s])
  (:import  [org.webbitserver WebServer WebServers WebSocketHandler]
            [org.webbitserver.handler StaticFileHandler])

  (:import java.util.Base64)

  (:gen-class :main true))

(declare cli-options
         ss:execute
         ss:compile
         ss:repl
         ss:server
         ss:print-errors)


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
   ["-s" "--server"      "run compiler as web-server"   :default false  :assoc-fn (fn [m k _] (update-in m [k] not))]
   [nil  "--port"        "server port"                  :default 8080   :parse-fn #(Integer/parseInt %)]
   ;; A boolean option defaulting to nil
   ["-h" "--help"]])

(defn -main [& args]
  (binding [*out* *err*]
    (println
      (bold
        (green  " __      _           _   __           _       _   \n"
                "/ _\\ ___| | ___  ___| |_/ _\\ ___ _ __(_)_ __ | |_ \n"
                "\\ \\ / _ \\ |/ _ \\/ __| __\\ \\ / __| '__| | '_ \\| __|\n"
                "_\\ \\  __/ |  __/ (__| |__\\ \\ (__| |  | | |_) | |_ \n"
                "\\__/\\___|_|\\___|\\___|\\__\\__/\\___|_|  |_| .__/ \\__|\n"
                "                                       |_|        \n"))))

  (let [{:keys [options arguments errors summary]} (parse-opts args cli-options)]
    (cond
      (:help options)         (println    summary)
      (:server options)       (ss:server  (:port options)
                                          (:optimize options))
      (or (:repl options)
        (empty? arguments))   (ss:repl    (:optimize options))
      :else (with-local-vars [code (slurp (first arguments))]
              (var-set code (parse @code))
              (if (= :error (first @code))
                (ss:print-errors (second @code))
                (do
                  (var-set code (second @code))
                  (if (:optimize options)   (var-set code (optimize @code)))
                  (if (:parse-tree options) (println @code))
                  (var-set code (assemble @code))
                  (if (:interim options)    (println @code))
                  (var-set code (cmp @code))
                  (if (:assembly options)   (dis @code))
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
                        (if (< status (:OK vm:status_codes))
                          (do
                            (if (= status (:YIELD vm:status_codes))
                              (println (grey "YIELD:" (vm:rslt env))))
                            (read-line)
                            (recur (vm:exec env prog 1)))))
                      (println "RESULT:" (vm:rslt env)))
                    (if (:execute options)
                      (ss:execute @code false)))))))))


(defn ss:print-errors [errors]
  (binding [*out* *err*]
    (loop [err errors]
      (if (not (empty? err))
        (do
          (println (first err))
          (recur (rest err)))))))


(defn on-message [connection message optimization]
  (println message)
  (println "-----------------------------")
  (let [rslt (ss:compile message optimization)]
    (println rslt)
    (if (= :ok (first rslt))
      (.send connection (.encodeToString  (Base64/getEncoder)
                                          (byte-array
                                            (second rslt)))))))


(defn ss:server [port opt]
  (println (format "Starting server at localhost:%d\n" port))
  (doto (WebServers/createWebServer port)
    (.add "/"
          (proxy [WebSocketHandler] []
            (onOpen    [c]   (println "opened" c))
            (onClose   [c]   (println "closed" c))
            (onMessage [c j] (on-message c j opt))))
    (.add (StaticFileHandler. "."))
    (.start)))


(defn ss:repl [opt]
  (let [env (vm:init 100 100 -1)]
    (println "(to quit press two times Ctrl-C)\n")
    (print ">>> ")
    (flush)
    (loop [code (read-line)]
      (let [rslt (ss:compile code opt)]
        (case (first rslt)
          :error  (ss:print-errors (second rslt))
          :ok     (let [status (vm:exec env (vm:prog (second rslt)) 0)]
                    (if (= status (:OK vm:status_codes))
                      (println (vm:rslt env))
                      (if (= status (:YIELD vm:status_codes))
                        (println (grey "YIELD" (vm:rslt env)))
                        (do
                          (println (red  "ERROR: " status))
                          (vm:reset env))))))
        (print  ">>> ")
        (flush))
      (recur (read-line)))))


(defn ss:compile [string opt]
  (let [rslt (parse string)]
    (if (= :error (first rslt))
      rslt
      (as-> (second rslt) input
        (if opt
          (optimize input)
          input)
        (assemble input)
        (cmp input)
        (list :ok input)))))



(defn ss:execute
  ([code]
   (ss:execute code false))
  ([code debug]
   (let [env (vm:init 100 100 (if debug 1 0)) prog (vm:prog code)]

     (loop [status 0]
       (if (= status (:YIELD vm:status_codes))
         (println "YIELD: " (vm:rslt env)))
       (if (< status (:OK vm:status_codes))
         (recur (vm:exec env prog (if debug 1 0)))))

     (let [status (vm:status env)]
       (if (= status (:OK vm:status_codes))
         (println "RESULT:" (vm:rslt env))
         (println (red "ERROR: " status)))))))

(defn ss:exec
  ([code op] (ss:exec (vm:init 100 10 0) code op))
  ([env code op] (let [rslt (ss:compile code op)]
                    (if (= :ok (first rslt))
                      (let [status (vm:exec env (vm:prog (second rslt)) 0)]
                        (if (= status (:OK vm:status_codes))
                          (vm:rslt env)
                          :error))
                      (rslt)))))
