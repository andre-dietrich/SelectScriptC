(ns selectscript.assembler
    (:use [selectscript.parser] :reload)
    (:use [selectscript.optimizer] :reload))


(declare assemble
         assemble:dict
         assemble:if
         assemble:loop
         assemble:op
         assemble:opX
         assemble:set
         assemble:val
         asm:loop
         pop:add
         pop:rm)


(defn assemble [ast]
  (case (first ast)
    (:dict)   (assemble:dict  (second ast))

    (:if)     (assemble:if    (rest ast))

    (:elem)   (concat (assemble (second ast))
                      (loop [elems [] code (last ast)]
                        (if (empty? code)
                          elems
                          (recur (concat elems
                                         (assemble (first code))
                                         '((:ELEM)))
                                 (rest code)))))

    (:exit)   (concat (assemble (second ast))
                      '((:EXIT)))

    (:fct)    (concat (asm:loop (last ast))
                      (assemble (second ast))
                      '((:CALL_FCT))
                      (list (count (last ast))))


    (:list)   (concat (asm:loop (second ast))
                      (list '(:CST_LST) (count (second ast))))

    (:loc)    (list '(:LOC) (second ast))

    (:loop)   (assemble:loop (second ast))

    (:op)     (assemble:op (rest ast))

    (:opX)    (assemble:opX (rest ast))

    (:ref)    (concat (assemble (second ast))
                      '((:REF)))

    (:set)    (concat (asm:loop (second ast))
                      (list '(:CST_SET) (count (second ast))))

    (:try)    (concat '((:SP_SAVE))
                      '((:TRY))
                      (assemble (nth ast 1))
                      '((:TRY_END))
                      (assemble (nth ast 2))
                      '((:TRY_END))
                      '((:RET)))

    (:val)    (assemble:val (second ast))

    (:var)    (list '(:LOAD) (second ast))

    (concat '((:SP_SAVE))
            (pop:rm (asm:loop ast true))
            '((:RET)))))


(defn assemble:dict [dict]
    (concat (asm:loop (vals dict)) (list '(:CST_DCT) (keys dict))))


(defn assemble:if [[if_ then_ else_]]
  (concat (assemble if_  ) '((:IF))
          (assemble then_) '((:THEN_END))
          (assemble else_) '((:ELSE_END))))

(defn assemble:loop [ast]
  (concat '((:SP_SAVE) (:LOOP_BEGIN))
          (if (list? (first ast))
            (asm:loop ast true)
            (assemble ast))
          '((:LOOP_END) (:RET_L))))


(defn assemble:op [[op params]]
  (if (= op :assign)
    (case (first (first params))
      :var  (concat (asm:loop (rest  params)) '((:STORE))     [(second (first params))])
      :loc  (concat (asm:loop (rest  params)) '((:STORE_LOC)) [(second (first params))])
      :elem (concat (assemble (first params))
                    (asm:loop (rest  params))
                    '((:STORE_RF))))
    (concat (asm:loop params)
            (list '(:CALL_OP)
                  op
                  (dec (count params))))))

(defn assemble:opX [[op params]]
  (concat (asm:loop params)
          (list '(:CALL_OPX)
                 op
                 (dec (count params)))))


(defn assemble:val [val]
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


(defn asm:loop
  ([ast] (asm:loop ast false))
  ([ast pop] (let [assemble_ (if pop
                              (comp pop:add assemble first)
                              (comp assemble first))]
               (loop [from ast, to '()]
                 (if (empty? from)
                   to
                   (recur (rest from)
                          (concat to
                                  (assemble_ from))))))))

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


;(assemble (parse "f(); f();"))
