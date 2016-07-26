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
         -dict
         -dict_elem
         -dict_id
         -element
         -function
         -list
         -prog
         -repo
         -set
         -stmt_list
         -value

         parse
         parseInt
         visitor)

(defmacro expr2 [op ctx two]
    `{:op ~op
        :elem [(.visit visitor (.e1 ~ctx))
            (if ~two
                (.visit visitor (.e2 ~ctx)))]})


(def visitor (proxy [SelectScriptBaseVisitor] []
    (visitAssign    [ctx] (-assign     ctx))
    (visitDict      [ctx] (-dict       ctx))
    (visitDict_elem [ctx] (-dict_elem  ctx))
    (visitDict_id   [ctx] (-dict_id    ctx))
    (visitFunction  [ctx] (-function   ctx))
    (visitList      [ctx] (-list       ctx))
    (visitProg      [ctx] (-prog       ctx))
    (visitRepo      [ctx] (-repo       ctx))
    (visitSet       [ctx] (-set        ctx))
    (visitStmt_list [ctx] (-stmt_list  ctx))
    (visitValue     [ctx] (-value      ctx))

    (visitEx_ex     [ctx] (expr2 :ex    ctx 0))
    (visitEx_not    [ctx] (expr2 :not   ctx 0))
    (visitEx_pos    [ctx] (expr2 :pos   ctx 0))
    (visitEx_neg    [ctx] (expr2 :neg   ctx 0))
    (visitEx_pow    [ctx] (expr2 :pow   ctx 1))
    (visitEx_div    [ctx] (expr2 :div   ctx 1))
    (visitEx_mod    [ctx] (expr2 :mod   ctx 1))
    (visitEx_mul    [ctx] (expr2 :mul   ctx 1))
    (visitEx_add    [ctx] (expr2 :add   ctx 1))
    (visitEx_sub    [ctx] (expr2 :sub   ctx 1))
    (visitEx_left   [ctx] (expr2 :left  ctx 1))
    (visitEx_right  [ctx] (expr2 :right ctx 1))
    (visitEx_iand   [ctx] (expr2 :iand  ctx 1))
    (visitEx_ixor   [ctx] (expr2 :ixor  ctx 1))
    (visitEx_ior    [ctx] (expr2 :ior   ctx 1))
    (visitEx_inot   [ctx] (expr2 :inot  ctx 0))
    (visitEx_lt     [ctx] (expr2 :lt    ctx 1))
    (visitEx_le     [ctx] (expr2 :le    ctx 1))
    (visitEx_ge     [ctx] (expr2 :ge    ctx 1))
    (visitEx_gt     [ctx] (expr2 :gt    ctx 1))
    (visitEx_ne     [ctx] (expr2 :ne    ctx 1))
    (visitEx_in     [ctx] (expr2 :in    ctx 1))
    (visitEx_eq     [ctx] (expr2 :eq    ctx 1))
    (visitEx_and    [ctx] (expr2 :and   ctx 1))
    (visitEx_xor    [ctx] (expr2 :xor   ctx 1))
    (visitEx_or     [ctx] (expr2 :or    ctx 1))
))


(defn parse
    [string]
    (let [tree (.prog
        (new SelectScriptParser
        (new CommonTokenStream
        (new SelectScriptLexer
        (new ANTLRInputStream string)))))]

        (.visit visitor tree)))


(parse "a= (3+3);")


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
    {:op :assign
     :elem [(-repo (.repo_ ctx))
                   (-stmt (.value_ ctx))]})


(defn -dict
    [ctx]
    {:dict (into {} (map -dict_elem (.elem_ ctx)))})


(defn -dict_elem
    [ctx]
    {(-dict_id (.id_ ctx)),
     (-stmt (.value_ ctx))})


(defn -dict_id
    [ctx]
    (if (.id_ ctx)
        (.getText (.id_ ctx))
        (cutString (.getText (.str_ ctx)))))


(defn -function
    [ctx]
    {:fct (-repo (.repo_ ctx))
     :params (if (.elem_ ctx)
                (-stmt_list (.elem_ ctx))
                () )})


(defn -list
    [ctx]
    {:list (if (.elem_ ctx)
            (-stmt_list (.elem_ ctx))
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
