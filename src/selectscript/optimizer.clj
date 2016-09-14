(ns selectscript.optimizer
    (:use [selectscript.parser] :reload)
    (:use [selectscript.defines] :reload))


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
      (:dict)  (optimize:dict (second ast))
      (:elem)  (ss:elem (optimize (second ast))
                        (optimize (last ast)))
      (:exit)  (ss:exit (optimize (second ast)))
      (:fct)   (ss:fct  (optimize (second ast))
                        (if (not-empty (last ast))
                          (optimize (last ast))
                          ()))
      (:if)    (optimize:if  (rest ast))
      (:list)  (ss:list (optimize (second ast)))
      (:loop)  (ss:loop (optimize (second ast)))
      (:op)    (optimize:op (rest ast))
      (:ref)   (ss:ref (optimize (second ast))) 
      (:select) (ss:select  (optimize:sel (nth ast 1))
                            (optimize:sel (nth ast 2))
                            (optimize (nth ast 3))
                            (optimize (nth ast 4))
                            (optimize (nth ast 5))
                            (optimize (nth ast 6))
                            (optimize (nth ast 7))
                            (optimize:order (nth ast 8))
                            (optimize (nth ast 9))
                            (nth ast 10))
      (:set)   (ss:set  (optimize (second ast)))
      (:try)   (ss:try  (optimize (second ast))
                        (optimize (last ast)))
      (:proc)  (optimize:proc (rest ast))
      (:loc)   (ss:loc (second ast) (optimize (last ast)))
      (:val)   ast
      (:var)   ast
      (:opX)   (ss:opX (second ast) (optimize (last ast)))
      (cons
        (optimize (first ast))
        (if (second ast)
          (optimize (rest ast)))))))


(defn optimize:proc [[params code info]]
  (let [code (optimize code)]
    (if (ss:val? code)
      code
      (ss:proc params
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
      (into [])
      (map #(hash-map (first %) (optimize (second %))))
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
      :ex     (ss:op :ex     params)
      :in     (ss:op :in     params)
      :neg    (opt_op - :neg params)
      :pos    params
      :not  (opt_op  ss:not  :not  params)
      :inot (opt_op  ss:inot :inot params)
      :add  (opt_ops ss:add  :add  params)
      :sub  (opt_ops ss:sub  :sub  params)
      :mul  (opt_ops ss:mul  :mul  params)
      :div  (opt_ops ss:div  :div  params)
      :mod  (opt_ops ss:mod  :mod  params)
      :pow (let [rslt (opt_ops ss:pow
                               :pow
                               (concat [(first params)]
                                       (opt:sort (rest params))))]
             (if (and (= :op  (first rslt))
                      (= :pow (second rslt))
                      (and (= :val (first (first (last rslt))))
                           (.contains [0 0.0 1 1.0 true false] (second (first (last rslt))))))
              (first (last rslt))
              rslt))

      :lt  (opt_opc ss:lt  :lt  params)
      :le  (opt_opc ss:le  :le  params)
      :gt  (opt_opc ss:gt  :gt  params)
      :ge  (opt_opc ss:ge  :ge  params)
      :eq  (let [p (distinct params)]
             (if (= 1 (count p))
               (ss:val true)
               (ss:op :eq p)))
      :ne  (if (not= (distinct params) params)
             (ss:val false)
             (ss:op :ne  params))
      :xor (opt_ops ss:xor :xor params)
      :and (let [op (opt_ops ss:and :and params)]
             (if (ss:val? op)
               op
               (if (.contains (last op) '(:val false))
                 (ss:val false)
                 (if (.contains (last op) '(:val nil))
                   (ss:val nil)
                   op))))
      :or  (let [op (opt_ops ss:or :or params)]
             (if (ss:val? op)
               op
               (if (.contains (last op) '(:val true))
                 (ss:val true)
                 (if (.contains (last op) '(:val nil))
                   (ss:val nil)
                   op))))
      :iand (let [rslt (opt_ops ss:iand
                               :iand
                               (opt:sort params))]
              (if (and (= :op   (first rslt))
                       (= :iand (second rslt))
                       (.contains (last rslt) '(:val 0)))
                (ss:val 0)
                rslt))
      :ior (opt_ops ss:ior
                    :ior
                    (opt:sort params))
      :ixor (opt_ops ss:ixor
                     :ixor
                     (opt:sort params))
      :left  (opt_ops ss:left  :left  params)
      :right (opt_ops ss:right :right params))))




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
               (= :ex (second p1)))
        (ss:op sym (list p1))
        p1)
      (if (not (ss:valX? p1 p2))
        (ss:op sym params)
        (recur op sym
               (cons (ss:val (op (second p1) (second p2)))
                     (nthrest params 2)))))))

;(use 'clojure.tools.trace)
;(trace-ns 'selectscript.optimizer)
;(optimize (parse "[2]+2;"))
