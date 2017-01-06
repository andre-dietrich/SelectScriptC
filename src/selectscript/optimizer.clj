(ns selectscript.optimizer
    (:use [selectscript.defines]    :reload))

(declare optimize
         optimize:if
         optimize:dict
         optimize:op
         optimize:proc
         optimize:sel
         optimize:order
         opt:sort
         opt_op
         opt_ops
         opt_opc)


(defn optimize [ast]
    ;(Thread/sleep 1000)
  (if (empty? ast)
    ()
    (case (first ast)
      :dict  (optimize:dict (second ast))
      :elem  (ss:elem (optimize (second ast))
                      (optimize (last ast)))
      :exit  (ss:exit (optimize (second ast)))
      :fct   (ss:fct  (optimize (second ast))
                      (if (not-empty (last ast))
                        (optimize (last ast))
                        ()))
      :fctX  (ss:fctX (optimize (second ast))
                      (optimize (last ast)))
      :if    (optimize:if  (rest ast))
      :list  (ss:list (optimize (second ast)))
      :loop  (ss:loop (optimize (second ast)))
      :op    (optimize:op (rest ast))
      :recur (ss:recur (optimize (second ast)))
      :ref   (ss:ref (optimize (second ast)))
      :sql   (ss:sql (optimize:sel (nth ast 1))
                     (optimize:sel (nth ast 2))
                     (optimize (nth ast 3))
                     (optimize (nth ast 4))
                     (optimize (nth ast 5))
                     (optimize (nth ast 6))
                     (optimize (nth ast 7))
                     (optimize:order (nth ast 8))
                     (optimize (nth ast 9))
                     (nth ast 10))
      :set   (ss:set  (optimize (second ast)))
      :try   (ss:try  (optimize (second ast))
                      (optimize (last ast)))
      :proc  (optimize:proc (rest ast))
      :loc   (ss:loc (second ast) (optimize (last ast)))
      :val   ast
      :var   ast
      :opX   (ss:opX (second ast) (optimize (last ast)))
      (cons
        (optimize (first ast))
        (if (second ast)
          (optimize (rest ast)))))))


(defn optimize:proc [[params code info]]
  (let [code (optimize code)]
    (if (ss:val? code)
      code
      (ss:proc (optimize params)
               code
               info))))

(defn optimize:order [ast]
  (loop [elem ast, rslt ()]
    (if (empty? elem)
      rslt
      (let [[expr dir] (first elem)]
        (recur (rest elem)
               (concat rslt [(list (optimize expr) dir)]))))))


(defn optimize:sel [params]
  (loop [p params o ()]
    (if (empty? p)
      o
      (recur (nthrest p 2)
             (concat o
                     [(first p)]
                     (list (optimize (second p))))))))

(defn optimize:if [[if_ then_ else_]]
  (if (ss:val? if_)
    (if (ss:bool? (second if_))
      then_
      else_)
    (ss:if if_ then_ else_)))


(defn optimize:dict [dict]
  (->> dict
      ;(into [])
      (map #(list (first %) (optimize (second %))))
      (ss:dict)))

(defn opt:sort [params]
  (loop [p_old params p_new ()]
    (if (empty? p_old)
      p_new
      (recur (rest p_old)
             (if (= :val (first (first p_old)))
               (concat [(first p_old)] p_new)
               (concat p_new [(first p_old)]))))))

(defn optimize:op [ast]
  (let [params (optimize (second ast))]
    (case (first ast)
      :assign (ss:op :assign params)
      :EX     (ss:op :EX     params)
      :IN     (ss:op :IN     params)
      :NEG    (opt_op - :NEG params)
      :POS    params
      :NOT  (opt_op  ss:not  :NOT  params)
      :B_NOT (opt_op  ss:inot :B_NOT params)
      :ADD  (opt_ops ss:add  :ADD  params)
      :SUB  (opt_ops ss:sub  :SUB  params)
      :MUL  (opt_ops ss:mul  :MUL  params)
      :DIV  (opt_ops ss:div  :DIV  params)
      :MOD  (opt_ops ss:mod  :MOD  params)
      :POW (let [rslt (opt_ops ss:pow
                               :POW
                               (concat [(first params)]
                                       (opt:sort (rest params))))]
             (if (and (= :op  (first rslt))
                      (= :POW (second rslt))
                      (and (= :val (first (first (last rslt))))
                           (.contains [0 0.0 1 1.0 true false] (second (first (last rslt))))))
              (first (last rslt))
              rslt))

      :LT  (opt_opc ss:lt  :LT  params)
      :LE  (opt_opc ss:le  :LE  params)
      :GT  (opt_opc ss:gt  :GT  params)
      :GE  (opt_opc ss:ge  :GE  params)
      :EQ  (let [p (distinct params)]
             (if (= 1 (count p))
               (ss:val true)
               (ss:op :EQ p)))
      :NE  (if (not= (distinct params) params)
             (ss:val false)
             (ss:op :NE  params))
      :XOR (opt_ops ss:xor :XOR params)
      :AND (let [op (opt_ops ss:and :AND params)]
             (if (ss:val? op)
               op
               (if (.contains (last op) '(:val false))
                 (ss:val false)
                 (if (.contains (last op) '(:val nil))
                   (ss:val nil)
                   op))))
      :OR  (let [op (opt_ops ss:or :OR params)]
             (if (ss:val? op)
               op
               (if (.contains (last op) '(:val true))
                 (ss:val true)
                 (if (.contains (last op) '(:val nil))
                   (ss:val nil)
                   op))))
      :B_AND (let [rslt (opt_ops ss:iand
                                :B_AND
                                (opt:sort params))]
               (if (and (= :op    (first rslt))
                        (= :B_AND (second rslt))
                        (.contains (last rslt) '(:val 0)))
                 (ss:val 0)
                 rslt))
      :B_OR (opt_ops ss:ior
                     :B_OR
                     (opt:sort params))
      :B_XOR (opt_ops ss:ixor
                      :B_XOR
                      (opt:sort params))
      :LEFT  (opt_ops ss:left  :LEFT  params)
      :RIGHT (opt_ops ss:right :RIGHT params))))




(defn opt_op [op sym param]
  (let [p (first param)]
    (if (ss:val? p)
      (ss:val (op (last p)))
      (ss:op sym param))))

(defn opt_opc [op sym params]
  (let [p (opt_ops op sym params)]
    (if (ss:val? p)
      (case (second p)
        :nil   (ss:val nil)
        :false (ss:val false)
        (ss:val true))
      (if (.contains (last p) '(:val :false))
        (ss:val false)
        (if (.contains (last p) '(:val :nil))
          (ss:val nil)
          p)))))

(defn opt_ops [op sym params]
  (let [p1  (first   params)
        p2  (second  params)]
    (if (nil? p2)
      (if (and (= :op (first  p1))
               (= :EX (second p1)))
        (ss:op sym (list p1))
        p1)
      (if (not (ss:valX? p1 p2))
        (ss:op sym params)
        (let [val (try
                    (ss:val (op (second p1) (second p2)))
                    (catch Exception e :error))]
          (if (= :error val)
            (ss:op sym params)
            (recur op sym
                   (cons val (nthrest params 2)))))))))

;(use 'clojure.tools.trace)
;(trace-ns 'selectscript.optimizer)
;(optimize (parse "[2]+2;"))
