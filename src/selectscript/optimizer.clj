(ns selectscript.optimizer
    (:use [selectscript.parser] :reload)
    (:use [selectscript.defines] :reload))


(declare optimize
         optimize:op
         optimize:if
         opt_op
         opt_ops)


(defn optimize [ast]
    (println "optimize" ast)
    ;(Thread/sleep 1000)
    (case (first ast)
      (:dict)  (optimize:dict (second ast))
      (:elem)  (ss:elem (optimize (second ast))
                        (optimize (last ast)))
      (:exit)  (ss:exit (optimize (second ast)))
      (:fct)   (ss:fct  (optimize (second ast))
                        (optimize (last ast)))
      (:if)    (optimize:if  (rest ast))
      (:list)  (ss:list (optimize (second ast)))
      (:loop)  (ss:loop (optimize (second ast)))
      (:op)    (optimize:op (rest ast))
      (:set)   (ss:set  (optimize (second ast)))
      (:try)   (ss:try  (optimize (second ast))
                        (optimize (last ast)))
      (:proc)  (optimize:proc (rest ast))
      (:loc)   ast
      (:value) ast
      (:var)   ast
      (:opX)   ast
      (cons
        (optimize (first ast))
          (if (second ast)
            (optimize (rest ast))))
      ))

(defn optimize:proc [ast]
  (let [code (optimize (second ast))]
    (if (ss:val? code)
      code
      (ss:proc (first ast)
               code
               (last ast)))))

(defn optimize:if [ast]
  (let [if_expr   (optimize (nth ast 0))
        then_expr (optimize (nth ast 1))
        else_expr (optimize (nth ast 2))]
        (println "sss" ast)
    (if (ss:val? if_expr)
      (if (ss:bool? (second if_expr))
        then_expr
        else_expr)
      (ss:if if_expr then_expr else_expr))))

(defn optimize:dict [ast]
  (->> ast
      (into [])
      (map #(hash-map (first %) (optimize (second %))))
      (ss:dict)))

(defn optimize:op [ast]
  (println "op" ast)
  (let [params (optimize (second ast))]
    (case (first ast)
      :pos params
      :neg (opt_op - :neg params)
      ;:not  (list :value (not (boolean? (second val1))))
      ;:inot (list :value (bit-not (second val1)))
      :add (opt_ops ss:add :add params)
      :sub (opt_ops ss:sub :sub params)
      :mul (opt_ops ss:mul :mul params)
      :div (opt_ops ss:div :div params)
      :mod (opt_ops ss:mod :mod params)
      :pow (opt_ops ss:pow :pow params)
      :xor (opt_ops ss:xor :xor params)
      :and (let [op (opt_ops ss:and :and params)]
             (if (ss:val? op)
               op
               (if (.contains (last op) '(:value false))
                 (ss:val false)
                 (if (.contains (last op) '(:value nil))
                   (ss:val nil)
                   op))))
      :or  (let [op (opt_ops ss:or :or params)]
             (if (ss:val? op)
               op
               (if (.contains (last op) '(:value true))
                 (ss:val true)
                 (if (.contains (last op) '(:value nil))
                   (ss:val nil)
                   op)))))))


(defn opt_op [op sym param]
  (let [p (optimize param)]
    (if (ss:val? p)
      (ss:val (sym p))
      (ss:op :op p))))


(defn opt_ops [op sym params]
  (let [p1  (first   params)
        p2  (second  params)]
    (if (nil? p2) p1
      (if (not (ss:val? p1 p2))
        (if (and (= :op (first p1)) (= sym (second p1)))
          (ss:op sym (concat (last p1) (list p2)))
          (ss:op sym params))
        (recur op sym
               (cons (ss:val (op (second p1) (second p2)))
                     (nthrest params 2)))))))

;(optimize (parse "2*2*2;"))
