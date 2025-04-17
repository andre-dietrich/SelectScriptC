(defproject selectscript "0.1.0-SNAPSHOT"
  :description "FIXME: write description"

  :url "http://example.com/FIXME"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure       "1.8.0"]
                 ;[net.n01se/clojure-jna     "1.0.0"]
                 ;[org.clojure/tools.trace   "0.7.9"]
                 [org.clojure/tools.cli     "0.3.5"]
                 [org.antlr/antlr4-runtime  "4.5.3"]
                 [org.antlr/antlr4          "4.5.3"]
                 [clojure-term-colors       "0.1.0-SNAPSHOT"]
                 ;; web-socket
                 ;[org.clojure/tools.logging "0.3.1"]
                 ;[environ                   "1.1.0"]
                 ;[compojure                 "1.5.1"]
                 ;[http-kit                  "2.2.0"]
                 ;[cheshire                  "5.6.3"]
                 ;; ------
                 [org.webbitserver/webbit   "0.4.15"]
                 [org.clojure/data.json     "0.1.2"]
                 ;; ------
                 [proto-repl                "0.3.1"]
                 [net.java.dev.jna/jna      "4.4.0"]]

  :plugins      [[lein-shell                "0.5.0"]]

;  :prep-tasks [["shell" "make"] "javac" "compile"]

  ;:resource-paths ["resources/antlr-4.5.3-complete.jar"]
  :resource-paths ["native"]
  :native-path "runtime"
  :native-prefix "runtime"

  ;; Add Java compiler options to target Java 8 compatibility
  :javac-options ["-source" "1.8" "-target" "1.8"]

  :java-source-paths ["src/antlr", "src/java"]

  ;:native-path "native"

  :jvm-opts ["-Djna.library.path=./runtime"]

  ;:jvm-opts ["-Djna.library.path=/home/andre/Workspace/Projects/gitlab/2SOS/runtime"]
  :profiles {:uberjar {:aot :all}}
  ;:keep-non-project-classes true
  :aot  [selectscript.core]
  :main selectscript.core)
