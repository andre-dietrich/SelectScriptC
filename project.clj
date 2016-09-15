(defproject selectscript "0.1.0-SNAPSHOT"
  :description "FIXME: write description"

  :url "http://example.com/FIXME"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure   "1.8.0"]
                 [net.n01se/clojure-jna "1.0.0"]
                 [org.clojure/tools.trace "0.7.9"]
                 [proto-repl            "0.3.1"]]
                 ;[net.java.dev.jna/jna  "4.1.0"]
  :plugins      [[lein-shell            "0.5.0"]]

;  :prep-tasks [["shell" "make"] "javac" "compile"]

  :resource-paths ["resources/antlr-4.5.3-complete.jar"]

  :java-source-paths ["src/antlr"]

  ;:native-path "native"

  :jvm-opts ["-Djna.library.path=./runtime"]

  ;:jvm-opts ["-Djna.library.path=/home/andre/Workspace/Projects/gitlab/2SOS/runtime"]
  :main selectscript.core)
