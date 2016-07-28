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
         -special
         -special2
         -stmt
         -stmt_list
         -try_expr
         -value
         -variable

         parse
         parseInt
         visitor
         visit)

(defmacro expr [op two]
    {:op op
     :params (let [param1 '(visit (.e1 ctx))]
                  (if (= 2 two)
                      [param1
                        '(visit (.e2 ctx))]
                      [param1]))})

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
    (visitSpecial   [ctx] (-special    ctx))
    (visitSpecial2  [ctx] (-special2   ctx))
    (visitStmt      [ctx] (-stmt       ctx))
    (visitStmt_list [ctx] (-stmt_list  ctx))
    (visitTry_expr  [ctx] (-try_expr   ctx))
    (visitValue     [ctx] (-value      ctx))
    (visitVariable  [ctx] (-variable   ctx))

    (visitEx_ex     [ctx] (expr :ex    1))
    (visitEx_not    [ctx] (expr :not   1))
    (visitEx_pos    [ctx] (expr :pos   1))
    (visitEx_neg    [ctx] (expr :neg   1))
    (visitEx_pow    [ctx] (expr :pow   2))
    (visitEx_div    [ctx] (expr :div   2))
    (visitEx_mod    [ctx] (expr :mod   2))
    (visitEx_mul    [ctx] (expr :mul   2))
    (visitEx_add    [ctx] (expr :add   2))
    (visitEx_sub    [ctx] (expr :sub   2))
    (visitEx_left   [ctx] (expr :left  2))
    (visitEx_right  [ctx] (expr :right 2))
    (visitEx_iand   [ctx] (expr :iand  2))
    (visitEx_ixor   [ctx] (expr :ixor  2))
    (visitEx_ior    [ctx] (expr :ior   2))
    (visitEx_inot   [ctx] (expr :inot  1))
    (visitEx_lt     [ctx] (expr :lt    2))
    (visitEx_le     [ctx] (expr :le    2))
    (visitEx_ge     [ctx] (expr :ge    2))
    (visitEx_gt     [ctx] (expr :gt    2))
    (visitEx_ne     [ctx] (expr :ne    2))
    (visitEx_in     [ctx] (expr :in    2))
    (visitEx_eq     [ctx] (expr :eq    2))
    (visitEx_and    [ctx] (expr :and   2))
    (visitEx_xor    [ctx] (expr :xor   2))
    (visitEx_or     [ctx] (expr :or    2))
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


(defn -special [ctx]
    (let [op (cond
                (.EQ       ctx) :eq
                (.NE       ctx) :ne
                (.LE       ctx) :le
                (.GE       ctx) :ge
                (.LT       ctx) :lt
                (.GT       ctx) :gt
                (.ADD      ctx) :add
                (.SUB      ctx) :sub
                (.MUL      ctx) :mul
                (.DIV      ctx) :div
                (.MOD      ctx) :mod
                (.POW      ctx) :pow
                (.IN       ctx) :in
                (.AND      ctx) :and
                (.OR       ctx) :or
                (.XOR      ctx) :xor
                (.IAND     ctx) :iand
                (.IXOR     ctx) :ixor
                (.IOR      ctx) :ior
                (.INV      ctx) :inv
                (.SHIFTR   ctx) :right
                (.SHIFTL   ctx) :left)
            params (-stmt_list (.elem_ ctx))]

            (if (and (= 1 (count params))
                     (or (= op :sub)
                         (= op :add))
                     (not (get params :fuct))
                     (not= (get (first params) :op) :ex))
                {:params params :op (if (= op :sub)
                                        :neg
                                        :pos)}
                {:params params :op op})))


(defn -special2 [ctx]
    (let [op   (-special (.op_ ctx))
          repo (visit (.repo_ ctx))]
          {:params (concat repo (get op :params))
           :opX    (case (get op :op)
                       :neg :sub
                       :pos :add
                       (get op :op))}))


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
