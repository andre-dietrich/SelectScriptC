(ns selectscript.interim
    (:use [selectscript.parser] :reload)
    (:use [selectscript.optimizer] :reload))


(declare interim
         interim:dict
         interim:if
         interim:loop
         interim:op
         interim:set
         interim:val
         int:loop
         pop:add
         pop:rm)


(defn interim [ast]
  (println "interim" ast)
  (case (first ast)
    (:dict)   (interim:dict  (second ast))

    (:if)     (interim:if    (rest ast))

    (:exit)   (concat (interim (second ast))
                      '((:EXIT)))

    (:fct)    (concat (int:loop (last ast))
                      (interim (second ast))
                      '((:CALL_FCT))
                      (list (count (last ast))))


    (:list)   (concat (int:loop (second ast))
                      (list '(:CST_LST) (count (second ast))))

    (:loc)    (list '(:LOC) (second ast))

    (:loop)   (interim:loop  (second ast))

    (:op)     (interim:op    (rest ast))

    (:ref)    (concat (interim (second ast))
                      '((:REF)))

    (:set)    (concat (int:loop (second ast))
                      (list '(:CST_SET) (count (second ast))))

    (:val)    (interim:val   (second ast))

    (:var)    (list '(:LOAD) (second ast))

    (concat '((:SP_SAVE))
            (pop:rm (int:loop ast true))
            '((:RET)))))


(defn interim:dict [dict]
    (concat (int:loop (vals dict)) (list '(:CST_DCT) (keys dict))))


(defn interim:if [[if_ then_ else_]]
  (concat (interim if_  ) '((:IF))
          (interim then_) '((:THEN_END))
          (interim else_) '((:ELSE_END))))

(defn interim:loop [ast]
  (concat '((:SP_SAVE) (:LOOP_BEGIN))

           (int:loop ast true)

          '((:LOOP_END) (:RET_L))))


(defn interim:op [[op params]]
    (println "interim op" op)
    (concat (int:loop params)
            (list '(:CALL_OP)
                  op
                  (dec (count params)))))

(defn interim:val [val]
    (println "interim:val" val)
  (cond
    (nil?     val)  '((:CST_N))
    (false?   val)  '((:CST_0))
    (true?    val)  '((:CST_1))
    (integer? val)  (if (and (< -127 val) (> 127 val))
                      (list '(:CST_B) val)
                      (if (and (< -32767 val) (> 32767 val))
                        (list '(:CST_S) val)
                        (list '(:CST_I) val)))
    (float?   val)  (list '(:CST_F) val)
    (string?  val)  (list '(:CST_STR) val)))


(defn int:loop
  ([ast] (int:loop ast false))
  ([ast pop] (let [interim_ (if pop
                              (comp pop:add interim first)
                              (comp interim first))]
               (loop [from ast, to '()]
                 (if (empty? from)
                   to
                   (recur (rest from)
                          (concat to
                                  (interim_ from))))))))

(defn pop:add [code]
  (loop [i (dec (count code))]
    (let [elem (nth code i)]
      (if (list? elem)
        (let [[left right] (split-at i code)]
          (concat left
                  (list (list (first elem) :POP))
                  (rest right)))
        (recur (dec i))))))

(defn pop:rm [code]
  (loop [i (dec (count code))]
    (let [elem (nth code i)]
      (if (list? elem)
        (let [[left right] (split-at i code)]
          (concat left (list (list(first elem))) (rest right)))
        (recur (dec i))))))


;(interim (parse "f();"))
