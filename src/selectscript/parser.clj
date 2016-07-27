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

(use 'clojure.tools.trace)
(trace-ns 'selectscript.parser)

(declare -atom
         -assign
         -dict
         -dict_elem
         -dict_id
         -element
         -function
         -if_expr
         -list
         -loc
         -loop
         -prog
         -set
         -stmt
         -stmt_list
         -try_expr
         -value
         -variable

         parse
         parseInt
         visitor
         visit)

(defmacro expr [op ctx two]
    `{:op ~op
        :param [(visit (.e1 ~ctx))
            (if ~two
                (visit (.e2 ~ctx)))]})

(def visitor (proxy [SelectScriptBaseVisitor] []
    (visitAssign    [ctx] (-assign     ctx))
    (visitAtom      [ctx] (-atom       ctx))
    (visitDict      [ctx] (-dict       ctx))
    (visitDict_elem [ctx] (-dict_elem  ctx))
    (visitDict_id   [ctx] (-dict_id    ctx))
    (visitElement   [ctx] (-element    ctx))
    (visitFunction  [ctx] (-function   ctx))
    (visitIf_expr   [ctx] (-if_expr    ctx))
    (visitList      [ctx] (-list       ctx))
    (visitLoc       [ctx] (-loc        ctx))
    (visitLoop      [ctx] (-loop       ctx))
    (visitProg      [ctx] (-prog       ctx))
    (visitSet       [ctx] (-set        ctx))
    (visitStmt      [ctx] (-stmt       ctx))
    (visitStmt_list [ctx] (-stmt_list  ctx))
    (visitTry_expr  [ctx] (-try_expr   ctx))
    (visitValue     [ctx] (-value      ctx))
    (visitVariable  [ctx] (-variable   ctx))

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


(defn visit
    [ctx]
    (.visit visitor ctx))


(defn parse
    [string]
    (let [tree (.prog
        (new SelectScriptParser
            (new CommonTokenStream
                (new SelectScriptLexer
                    (new ANTLRInputStream string)))))]

        (visit tree)))


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


(defn -assign [ctx]
    {:op :assign
     :params [(visit (.repo_  ctx))
              (visit (.value_ ctx))]})


(defn -atom [ctx]
    (if (.elem_ ctx)
        (visit (.elem_ ctx))
        (.visitChildren visitor ctx)))


(defn -dict [ctx]
    {:dict (into {} (map -dict_elem (.elem_ ctx)))})


(defn -dict_elem [ctx]
    {(-dict_id (.id_ ctx)),
     (visit (.value_ ctx))})


(defn -dict_id [ctx]
    (if (.id_ ctx)
        (.getText (.id_ ctx))
        (cutString (.getText (.str_ ctx)))))


(defn -element [ctx]
    (defn children
    	([ctx]
            (children ctx 2 (.getChildCount ctx)))
    	([ctx i max]
            (if (< i max)
                (lazy-seq
                    (cons (let [elem (visit (.getChild ctx i))]
                               (if (string? elem)
                                   {:value (if (not= (first elem) "\"")
                                               (if (not= (first elem) "'")
                                                    elem)
                                               (cutString elem))}
                                    elem))
                          (children ctx (inc i) max))))))

    {:element (if (.var_ ctx)
                  (-variable (.var_ ctx))
                  (if (.stmt_ ctx)
                      (-stmt (.stmt_ ctx))
                      (-loc  (.loc_ ctx))))
     :params (remove nil? (children ctx))})


(defn -function [ctx]
    {:fct (visit (.repo_ ctx))
     :params (if (.elem_ ctx)
                (-stmt_list (.elem_ ctx))
                () )})

(defn -if_expr [ctx]
    {:if (-stmt (.if_ ctx))
     :then (if (.then_ ctx)
               (-stmt (.then_ ctx))
               {:value true})
     :else (if (.else_ ctx)
               (-stmt (.else_ ctx))
               {:value false})})


(defn -list [ctx]
    {:list (if (.elem_ ctx)
               (-stmt_list (.elem_ ctx))
               () )})


(defn -loop [ctx]
    {:loop (-stmt (.do_ ctx))})


(defn -loc [ctx]
    (let [loc {:loc (if (.id_ ctx)
                    (.getText (.id_ ctx))
                    "")}]
         (if (.extra_ ctx)
             (assoc loc :extra (-stmt (.extra_ ctx)))
             loc)))


(defn -prog [ctx]
    (map visit (.elem_ ctx)))


(defn -set [ctx]
    {:set (if (.elem_ ctx)
              (set (-stmt_list (.elem_ ctx)))
              (set ()) )})


(defn -stmt [ctx]
    (if (.seq_ ctx)
        (-prog (.seq_ ctx))
        (.visitChildren visitor ctx)))


(defn -try_expr [ctx]
    {:try (-stmt (.try_ ctx))
     :catch (if (.catch_ ctx)
                (-stmt (.catch_ ctx))
                {:value nil})})


(defn -stmt_list [ctx]
    (map visit (.elem_ ctx)))


(defn -value [ctx]
    {:value (cond
            (.true_  ctx) true
            (.false_ ctx) false
            (.none_  ctx) nil
            (.int_   ctx) (parseInt (.getText ctx))
            (.float_ ctx) (read-string (.getText ctx))
            (.str_   ctx) (cutString (.getText ctx)))})


(defn -variable [ctx]
    {:var (.getText ctx)})
