(ns selectscript.core
    ;;(:use selectscript.parser)
    ;;(:gen-class
    ;; :extends selectscript.antlr.Test
    ;; :main false)
    ;:require '(selectscript.parser)

    (:use [selectscript.parser] :reload)
    (:use [selectscript.optimizer] :reload)
    (:use [selectscript.compiler] :reload))


;((optimize (parse "2+(3+4);")))

(defn -main
  "I don't do a whole lot."
  [& args]
  (println "testing"))
