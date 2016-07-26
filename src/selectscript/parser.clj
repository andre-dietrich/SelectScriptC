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

(defmacro expr [op ctx two]
    `{:op ~op
        :elem [(visit (.e1 ~ctx))
            (if ~two
                (visit (.e2 ~ctx)))]})

(defn visit
    [elem]
    (.visit visitor elem))

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

    (visitEx_ex     [ctx] (expr :ex    ctx 0))
    (visitEx_not    [ctx] (expr :not   ctx 0))
    (visitEx_pos    [ctx] (expr :pos   ctx 0))
    (visitEx_neg    [ctx] (expr :neg   ctx 0))
    (visitEx_pow    [ctx] (expr :pow   ctx 1))
    (visitEx_div    [ctx] (expr :div   ctx 1))
    (visitEx_mod    [ctx] (expr :mod   ctx 1))
    (visitEx_mul    [ctx] (expr :mul   ctx 1))
    (visitEx_add    [ctx] (expr :add   ctx 1))
    (visitEx_sub    [ctx] (expr :sub   ctx 1))
    (visitEx_left   [ctx] (expr :left  ctx 1))
    (visitEx_right  [ctx] (expr :right ctx 1))
    (visitEx_iand   [ctx] (expr :iand  ctx 1))
    (visitEx_ixor   [ctx] (expr :ixor  ctx 1))
    (visitEx_ior    [ctx] (expr :ior   ctx 1))
    (visitEx_inot   [ctx] (expr :inot  ctx 0))
    (visitEx_lt     [ctx] (expr :lt    ctx 1))
    (visitEx_le     [ctx] (expr :le    ctx 1))
    (visitEx_ge     [ctx] (expr :ge    ctx 1))
    (visitEx_gt     [ctx] (expr :gt    ctx 1))
    (visitEx_ne     [ctx] (expr :ne    ctx 1))
    (visitEx_in     [ctx] (expr :in    ctx 1))
    (visitEx_eq     [ctx] (expr :eq    ctx 1))
    (visitEx_and    [ctx] (expr :and   ctx 1))
    (visitEx_xor    [ctx] (expr :xor   ctx 1))
    (visitEx_or     [ctx] (expr :or    ctx 1))
))


(defn parse
    [string]
    (let [tree (.prog
        (new SelectScriptParser
        (new CommonTokenStream
        (new SelectScriptLexer
        (new ANTLRInputStream string)))))]

        (visit tree)))


(parse "3+3;")


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
                   (visit (.value_ ctx))]})


(defn -dict
    [ctx]
    {:dict (into {} (map -dict_elem (.elem_ ctx)))})


(defn -dict_elem
    [ctx]
    {(-dict_id (.id_ ctx)),
     (visit (.value_ ctx))})


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
    (map visit (.elem_ ctx)))


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
    (map visit (.elem_ ctx)))


(defn -value
  [ctx]
  {:value (if (.true_ ctx) true
            (if (.false_ ctx) false
              (if (.none_ ctx) nil
                (let [string (.getText ctx)]
                  (if (.int_ ctx) (parseInt string)
                      (if (.float_ ctx) (read-string string)
                          (if (.str_ ctx) (cutString string))))))))})
