(ns selectscript.parser
    (:import (org.antlr.v4.runtime CommonTokenStream
                                   ANTLRInputStream)
             (org.antlr.v4.runtime.tree Tree
                                        ParseTree
                                        ParseTreeWalker
                                        ParseTreeVisitor)
             (S2 SelectScriptLexer
                 SelectScriptParser
                 SelectScriptBaseVisitor)))

(declare -assign
         -atom
         -dict
         -dict_elem
         -function
         -list
         -prog
         -repo
         -set
         -stmt
         -stmt_list
         -value

         parse
         parseInt
         visitor)


(def visitor (proxy [SelectScriptBaseVisitor] []
    (visitAssign    [ctx] (-assign     ctx))
    (visitAtom      [ctx] (-atom       ctx))
    (visitDict      [ctx] (-dict       ctx))
    (visitDict_elem [ctx] (-dict_elem  ctx))
    (visitFunction  [ctx] (-function   ctx))
    (visitList      [ctx] (-list       ctx))
    (visitProg      [ctx] (-prog       ctx))
    (visitRepo      [ctx] (-repo       ctx))
    (visitSet       [ctx] (-set        ctx))
    (visitStmt      [ctx] (-stmt       ctx))
    (visitStmt_list [ctx] (-stmt_list  ctx))
    (visitValue     [ctx] (-value      ctx))))


(defn parse
    [string]
    (let [tree (.prog
        (new SelectScriptParser
        (new CommonTokenStream
        (new SelectScriptLexer
        (new ANTLRInputStream string)))))]

        (.visit visitor tree)))

(parse "{eee:[1,2], f:[]};")


(defn cutString
    [string]
    (subs string 1 (- (count string) 1)))

(defn parseInt
    "convert a string to int"
    [string]
    (defn del0
        [string]
            (if (not= (first string) \0)
                string
                (recur (subs string 1))))

        (if (< (count string) 2)
            (Integer/parseInt string)
            (case (subs string 0 2)
                "0b" (Integer/parseInt (del0 (subs string 2)) 2)
                "0o" (Integer/parseInt (del0 (subs string 2)) 8)
                "0x" (Integer/parseInt (del0 (subs string 2)) 16)
                (Integer/parseInt (del0 string)))))

(defn -assign
    [ctx]
    {:op {:id "="
          :params [(-repo (.repo_ ctx))
                   (-stmt (.value_ ctx))]}})

(defn -atom
    [ctx]
    (.visitChildren visitor ctx))


(defn -dict
    [ctx]
    {:dict (into {} (map -dict_elem (.elem_ ctx)))})


(defn -dict_elem
    [ctx]
    {(if (.id_ ctx)
        (.getText (.id_ ctx))
        (cutString (.getText (.str_ ctx)))),
     (-stmt (.value_ ctx))})


(defn -function
    [ctx]
    {:fct (-repo (.repo_ ctx))
     :params (if (.params_ ctx)
                (-stmt_list (.params_ ctx))
                () )})


(defn -list
    [ctx]
    {:list (if (.params_ ctx)
            (-stmt_list (.params_ ctx))
            () )})


(defn -prog
    [ctx]
    (map -stmt (.elem_ ctx)))


(defn -repo
    [ctx]
    (if (.name_ ctx)
        {:var (.getText ctx)}))


(defn -set
    [ctx]
    {:set
        (if (.elem_ ctx)
            (set  (-stmt_list (.elem_ ctx)))
             (set ())) })

(defn -stmt
    [ctx]
    (.visitChildren visitor ctx))


(defn -stmt_list
    [ctx]
    (map -stmt (.elem_ ctx)))


(defn -value
  [ctx]
  {:value (if (.true_ ctx) true
            (if (.false_ ctx) false
              (if (.none_ ctx) nil
                (let [string (.getText ctx)]
                  (if (.int_ ctx) (parseInt string)
                      (if (.float_ ctx) (read-string string)
                          (if (.str_ ctx) (cutString string))))))))})
