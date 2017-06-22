(ns selectscript.parser
  (:import (org.antlr.v4.runtime      CommonTokenStream
                                      ANTLRInputStream)
           (org.antlr.v4.runtime.tree Tree
                                      ParseTree
                                      ParseTreeWalker
                                      ParseTreeVisitor)
           (S2 SelectScriptLexer
               SelectScriptParser
               SelectScriptBaseVisitor
               SelectScriptErrorListener))

  (:use [selectscript.defines :only (ss:dict  ss:elem
                                     ss:exit  ss:fct
                                     ss:fctX  ss:if
                                     ss:list  ss:loc
                                     ss:loop  ss:op
                                     ss:opX   ss:proc
                                     ss:recur ss:ref
                                     ss:sql   ss:set
                                     ss:try   ss:val
                                     ss:val?  ss:var
                                     ss:yield)]    :reload))

(declare -atom
         -assign
         -dict
         -dict_elem
         -dict_id
         -element
         -exit
         -function
         -function_del
         -function_mem
         -if_expr
         -import_s2
         -list
         -loc
         -loop
         -pipe
         -pipe_allowed
         -procedure
         -procedure_params
         -prog
         -recur_expr
         -reference
         -selection
         -sel_as
         -sel_connect
         -sel_dir
         -sel_list
         -sel_order
         -set
         -special
         -special2
         -stmt
         -stmt_list
         -try_expr
         -value
         -variable
         -yield

         expr
         parse
         parseInt
         visitor
         visit)


(defn expr [op ctx]
  (ss:op op (let [p1 (visit (.e1 ctx))
                  p2 (visit (.e2 ctx))]
              (if (and (= :op (first p1))
                       (=  op (second p1)))
                (concat (last p1) [p2])
                (concat [p1] [p2])))))

(def visitor
  (proxy [SelectScriptBaseVisitor] []
    (visitAssign       [ctx] (ss:op :assign [(visit (.e1 ctx))
                                             (visit (.e2 ctx))]))
    (visitAtom         [ctx] (-atom         ctx))
    (visitDict         [ctx] (-dict         ctx))
    (visitDict_elem    [ctx] (-dict_elem    ctx))
    (visitDict_id      [ctx] (-dict_id      ctx))
    (visitElement      [ctx] (-element      ctx))
    (visitExit         [ctx] (-exit         ctx))
    (visitFunction     [ctx] (-function     ctx))
    (visitFunction_del [ctx] (-function_del ctx))
    (visitFunction_mem [ctx] (-function_mem ctx))
    (visitIf_expr      [ctx] (-if_expr      ctx))
    (visitImport_s2    [ctx] (-import_s2    ctx))
    (visitList         [ctx] (-list         ctx))
    (visitLoc          [ctx] (-loc          ctx))
    (visitLoop         [ctx] (-loop         ctx))
    (visitPipe         [ctx] (-pipe         ctx))
    (visitPipe_allowed [ctx] (-pipe_allowed ctx))
    (visitProcedure    [ctx] (-procedure    ctx))
    (visitProcedure_params [ctx] (-procedure_params    ctx))
    (visitProg         [ctx] (-prog         ctx))
    (visitRecur_expr   [ctx] (-recur_expr   ctx))
    (visitReference    [ctx] (-reference    ctx))
    (visitSelection    [ctx] (-selection    ctx))
    (visitSel_as       [ctx] (-sel_as       ctx))
    (visitSel_connect  [ctx] (-sel_connect  ctx))
    (visitSel_dir      [ctx] (-sel_dir      ctx))
    (visitSel_list     [ctx] (-sel_list     ctx))
    (visitSel_order    [ctx] (-sel_order    ctx))
    (visitSet          [ctx] (-set          ctx))
    (visitSpecial      [ctx] (-special      ctx))
    (visitSpecial2     [ctx] (-special2     ctx))
    (visitStmt         [ctx] (-stmt         ctx))
    (visitStmt_list    [ctx] (-stmt_list    ctx))
    (visitTry_expr     [ctx] (-try_expr     ctx))
    (visitValue        [ctx] (-value        ctx))
    (visitVariable     [ctx] (-variable     ctx))

    (visitYield        [ctx] (-yield        ctx))

    (visitEx_ex        [ctx] (ss:op :EX  [(visit (.e1 ctx))]))
    (visitEx_not       [ctx] (ss:op :NOT [(visit (.e1 ctx))]))
    (visitEx_pos       [ctx] (visit (.e1 ctx)))
    (visitEx_neg       [ctx]
        (let [ex (visit (.e1 ctx))]
          (if (ss:val? ex)
            (ss:val (- (second ex)))
            (ss:op :NEG (list ex)))))
    (visitEx_pow       [ctx] (expr :POW  ctx))
    (visitEx_div_mod_mul [ctx] (expr (cond
                                       (.DIV ctx) :DIV
                                       (.MOD ctx) :MOD
                                       (.MUL ctx) :MUL)
                                     ctx))
    (visitEx_add_sub  [ctx] (expr (if (.ADD ctx)
                                    :ADD
                                    :SUB)
                                  ctx))
    (visitEx_shift    [ctx] (expr (if (.SHIFTL ctx)
                                    :LEFT
                                    :RIGHT)
                                  ctx))
    (visitEx_iand     [ctx] (expr :B_AND ctx))
    (visitEx_ixor     [ctx] (expr :B_XOR ctx))
    (visitEx_ior      [ctx] (expr :B_OR  ctx))
    (visitEx_inot     [ctx] (ss:op :B_NOT  [(visit (.e1 ctx))]))
    (visitEx_lt       [ctx] (expr :LT   ctx))
    (visitEx_le       [ctx] (expr :LE   ctx))
    (visitEx_ge       [ctx] (expr :GE   ctx))
    (visitEx_gt       [ctx] (expr :GT   ctx))
    (visitEx_ne       [ctx] (expr :NE   ctx))
    (visitEx_in       [ctx] (expr :IN   ctx))
    (visitEx_eq       [ctx] (expr :EQ   ctx))
    (visitEx_id       [ctx] (expr :ID   ctx))
    (visitEx_and      [ctx] (expr :AND  ctx))
    (visitEx_xor      [ctx] (expr :XOR  ctx))
    (visitEx_or       [ctx] (expr :OR   ctx))))


(defn visit [ctx]
  (.visit visitor ctx))


(defn parse [string]
  (let [input (ANTLRInputStream. string)]
    (let [lexer (SelectScriptLexer. input)]
      (let [error-listener (new SelectScriptErrorListener)]
        (let [token (CommonTokenStream. lexer)]
          (let [parser (SelectScriptParser. token)]
            (.removeErrorListeners parser)
            (.addErrorListener parser error-listener)
            (let [tree (.prog parser)]
              (if (.hasErrors error-listener)
                (list :error (into [] (.getErrors error-listener)))
                (list :ok    (visit tree))))))))))


(defn cutString [string]
    (subs string 1 (- (count string) 1)))


(defn parseInt
  "convert a string to int"
  [string]
  (defn del0 [string]
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


(defn -atom [ctx]
  (if-let [rec (.xxx ctx)]
    (-recur_expr rec)
    (if-let [elem (.elem_ ctx)]
      (visit elem)
      (if-let [prog (.prog_ ctx)]
        (visit prog)
        (.visitChildren visitor ctx)))))

(defn children
  ([ctx start]
   (children ctx start (.getChildCount ctx)))
  ([ctx i max]
   (if (< i max)
     (lazy-seq
       (cons
         (let [elem (visit (.getChild ctx i))]
           (if (string? elem)
             (ss:val (if (not= (first elem) "\"")
                       (if (not= (first elem) "'")
                         elem)
                       (cutString elem)))
             elem))
         (children ctx (inc i) max))))))


(defn -dict [ctx]
  (ss:dict (map -dict_elem (.elem_ ctx))))


(defn -dict_elem [ctx]
  [(-dict_id (.id_ ctx)),
   (visit (.value_ ctx))])


(defn -dict_id [ctx]
  (if-let [id (.id_ ctx)]
    (.getText id)
    (cutString (.getText (.str_ ctx)))))


(defn -element [ctx]
  (ss:elem
    (if-let [var (.var_ ctx)]
      (-variable var)
      (if-let [stmt (.stmt_ ctx)]
        (-stmt stmt)
        (-loc  (.loc_ ctx))))
    (remove nil? (children ctx 2))))

(defn -exit [ctx]
  (ss:exit (if-let [exit (.stmt ctx)]
             (-stmt exit)
             (ss:var nil))))


(defn -function [ctx]
  (if-let [mem (.mem_ ctx)]
    (-function_mem mem)
    (if-let [del (.del_ ctx)]
      (-function_del del)
      (if-let [extra (.extra_ ctx)]
        (ss:fctX (visit extra)
                 [(visit (.repo_ ctx))]
                 (if-let [elem (.elem_ ctx)]
                   (-stmt_list elem)
                   ()))
        (ss:fct (visit (.repo_ ctx))
                (if-let [elem (.elem_ ctx)]
                  (-stmt_list elem)
                  ()))))))


(defn -function_del [ctx]
  (ss:fct (ss:var (.getText (.DEL_F ctx)))
          (let [max (dec (.getChildCount ctx))]
            (reverse (loop [i 2, params '()]
                       (if (>= i max)
                         params
                         (recur (+ i 2) (let [child (.getText (.getChild ctx i))]
                                          (conj params (ss:val (if (.contains [\" \'] (first child))
                                                                 (cutString child)
                                                                 child)))))))))))

(defn -function_mem [ctx]
  (ss:fct (ss:var (.getText (.MEM_F ctx)))
          (if-let [ident (.IDENTIFIER ctx)]
            (list (ss:val (.getText ident)))
            (if-let [string (.STRING ctx)]
              (list (ss:val (cutString (.getText string))))
              ()))))

(defn -if_expr [ctx]
  (ss:if (-stmt (.if_ ctx))
         (if-let [then (.then_ ctx)]
          (-stmt then)
          (ss:val true))
        (if-let [else (.else_ ctx)]
          (-stmt else)
          (ss:val false))))

(defn -import_s2 [ctx]
  (let [rslt (-> ctx
                  (.file)
                  (.getText)
                  (cutString)
                  (slurp)
                  (parse))]
    (if (= :ok (first rslt))
      (second rslt))))


(defn -list [ctx]
  (ss:list (if-let [elem (.elem_ ctx)]
             (-stmt_list elem)
             ())))


(defn -loop [ctx]
  (ss:loop (-stmt (.do_ ctx))))


(defn -loc [ctx]
  (ss:loc (if-let [id (.id_ ctx)]
            (.getText id)
            "")
          (if-let [extra (.extra_ ctx)]
            (-stmt extra)
            ())
          (if-let [extra2 (.extra2_ ctx)]
            (case (clojure.string/lower-case (.getText extra2))
              "step"    :LOC_STEP
              "count"   :LOC_COUNT
              nil))))

(defn -pipe [ctx]
  (loop [elem (-pipe_allowed (.pipe_ ctx)), e (visit (.e ctx))]
    (if (empty? elem)
      e
      (let [pipe_elem (first elem)]
        (recur (rest elem)
               (let [[x, name, parameter] pipe_elem]
                 [x, name, (if (empty? parameter)
                             [e]
                             (concat [e] parameter))]))))))


(defn -pipe_allowed [ctx]
  (let [end (.getChildCount ctx)]
    (loop [i 1 elems []]
      (if (< end i)
        elems
        (recur (+ i 2)
               (concat elems
                       (let [e (.getChild ctx i)]
                         [(visit e)])))))))

(defn -procedure [ctx]
  (ss:proc (if (.params_ ctx)
             (-procedure_params (.params_ ctx))
             (ss:val nil))
           (-stmt (.code_ ctx))
           (if (.info_ ctx)
             (cutString (.getText (.info_ ctx)))
             "")))

(defn -procedure_params [ctx]
  (let [end (.getChildCount ctx)]
    (ss:dict (loop [i 0 elems []]
               (if (< end i)
                 elems
                 (recur (+ i 2)
                        (concat elems
                                (let [e (.getChild ctx i)]
                                  (if (= (type e)
                                         S2.SelectScriptParser$Dict_elemContext)
                                    [(visit e)]
                                    (let [id (.getText e)]
                                      [[(if (= "$" id) "" id)
                                        (ss:val nil)]]))))))))))


(defn -prog [ctx]
  (map visit (.elem_ ctx)))

(defn -recur_expr [ctx]
  (ss:recur (if-let [elem (.elements_ ctx)]
              (-stmt_list elem)
              ())))

(defn -reference [ctx]
  (ss:ref (visit (.elem ctx))))


(defn -set [ctx]
  (ss:set (if-let [elem (.elem_ ctx)]
            (-stmt_list elem)
            (list))))

(defn -selection [ctx]
  (let [select  (.select_  ctx)  from  (.from_    ctx)
        where   (.where_   ctx)  start (.start_   ctx)
        connect (.connect_ ctx)  stop  (.stop_    ctx)
        group   (.group_   ctx)  order (.order_   ctx)
        limit   (.limit_   ctx)  as    (.as_      ctx)]
    (ss:sql
      (visit from)
      (if select    (visit select)          (list "" (ss:loc "" ())))
      (if where     (visit where)           ())
      (if start     (visit start)           ())
      (if connect   (-sel_connect connect)  ())
      (if stop      (visit stop)            ())
      (if group     (visit group)           ())
      (if order     (-sel_order order)      ())
      (if limit     (visit limit)           ())
      (if as        (-sel_as as)            :list))))

(defn -sel_as [ctx]
  (let [as (.getText (.IDENTIFIER ctx))]
    (case (clojure.string/lower-case as)
      "dict"         :dict
      "dictionary"   :dict
      "list"         :list
      "set"          :set
      "val"          :val
      "value"        :val
      "void"         :void
      as)))

(defn -sel_connect [ctx]
  (list (-stmt_list (.elem_ ctx))
        (if (.CYCLE ctx)
          '(:IT_CYCLE)
          (if (.UNIQUE ctx)
            '(:IT_UNIQUE)
            (if (.MEMORIZE ctx)
              '(:IT_MEMORIZE)
              '())))
        (if (.COST ctx)
          (visit (.cost_ ctx))
          '())))

(defn -sel_order [ctx]
  (with-local-vars [ast ()]
    (let [end (.getChildCount ctx)]
      (loop [i 0]
        (if (= end i)
          @ast
          (let [child (.getChild ctx i)]
            (if (= (type child) S2.SelectScriptParser$StmtContext)
              (var-set ast (concat @ast
                                   [(list (visit child) :asc)]))
              (if (and (= (type child) S2.SelectScriptParser$Sel_dirContext)
                       (= :desc (-sel_dir child)))
                (var-set ast (concat (butlast @ast)
                                     [(list (first (last @ast)) :desc)]))))
            (recur (inc i))))))))

(defn -sel_dir [ctx]
    (if (.ASC ctx) :asc :desc))

(defn -sel_list [ctx]
  (let [lst (remove nil? (children ctx 0))]
    (loop [l lst d []]
      (if (empty? l)
        d
        (recur (rest l)
               (concat d
                       (let [elem (first l)]
                         (if (string? (first elem))
                           elem
                           (case (first elem)
                             :var  [(second elem) elem]
                             :loc  [(second elem) elem]
                             :fct  [(second (second elem)) elem]
                             :elem [(str (last (last (last elem)))) elem]
                             ["" elem])))))))))

(defn -special [ctx]
  (let [params (-stmt_list (.elem_ ctx))
        op (cond
             (.EQ       ctx) :EQ
             (.NE       ctx) :NE
             (.LE       ctx) :LE
             (.GE       ctx) :GE
             (.LT       ctx) :LT
             (.GT       ctx) :GT
             (.ADD      ctx) :ADD
             (.SUB      ctx) :SUB
             (.MUL      ctx) :MUL
             (.DIV      ctx) :DIV
             (.MOD      ctx) :MOD
             (.POW      ctx) :POW
             (.IN       ctx) :IN
             (.AND      ctx) :AND
             (.OR       ctx) :OR
             (.XOR      ctx) :XOR
             (.IAND     ctx) :B_AND
             (.IXOR     ctx) :B_XOR
             (.IOR      ctx) :B_OR
             (.SHIFTR   ctx) :RIGHT
             (.SHIFTL   ctx) :LEFT)]

    (if (and (= 1 (count params))
             (or (= op :SUB) (= op :ADD))
             (and (not= :fct (first (first params)))
                  (and (not= :op  (first (first params)))
                       (not= :EX  (second (first params))))))
      (ss:op (if (= op :SUB)
               :NEG
               :POS)
            params)
      (ss:op op params))))


(defn -special2 [ctx]
    (cond
      (.NOT ctx) (ss:opX :NOT   (list (visit (.repo_ ctx))))
      (.INV ctx) (ss:opX :B_NOT (list (visit (.repo_ ctx))))
      (.ADD ctx) (ss:opX :POS   (list (visit (.repo_ ctx))))
      (.SUB ctx) (ss:opX :NEG   (list (visit (.repo_ ctx))))
      :else      (let [op   (-special (.op_ ctx))
                       repo (visit (.repo_ ctx))]
                   (ss:opX (case (second op)
                             :NEG :SUB
                             :POS :ADD
                             (second op))
                           (cons repo (last op))))))


(defn -stmt [ctx]
  (if-let [seq (.seq_ ctx)]
        (-prog seq)
        (.visitChildren visitor ctx)))


(defn -try_expr [ctx]
  (ss:try (-stmt (.try_ ctx))
          (if (.catch_ ctx)
            (-stmt (.catch_ ctx))
            (ss:val nil))))


(defn -stmt_list [ctx]
  (map visit (.elem_ ctx)))


(defn -value [ctx]
  (ss:val (cond
            (.true_  ctx) true
            (.false_ ctx) false
            (.none_  ctx) nil
            (.int_   ctx) (parseInt (.getText ctx))
            (.float_ ctx) (read-string (.getText ctx))
            (.str_   ctx) (cutString (.getText ctx)))))


(defn -variable [ctx]
  (ss:var (.getText ctx)))

(defn -yield [ctx]
  (ss:yield (visit (.elem_ ctx))))
