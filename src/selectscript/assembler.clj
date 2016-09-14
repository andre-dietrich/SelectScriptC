(ns selectscript.assembler
    ;(:use [selectscript.parser] :reload)
    (:use [selectscript.optimizer] :reload)
    (:use [selectscript.compiler]  :reload))


(declare assemble
         assemble:dict
         assemble:if
         assemble:loop
         assemble:op
         assemble:opX
         assemble:proc
         assemble:selection
         assemble:sel_as
         assemble:sel_from
         assemble:sel_select
         assemble:sel_where
         assemble:sel_order
         assemble:sel_group
         assemble:sel_limit
         assemble:set
         assemble:val
         asm:loop
         pop:add
         pop:rm)

(def as_value {:void 0 :val 1 :list 2 :set 4 :dict 3})


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

    (:loc)    (if (empty? (last ast))
                (list '(:LOC) (second ast))
                (concat (assemble (last ast))
                        (list '(:LOCX) (second ast))))

    (:loop)   (assemble:loop (second ast))

    (:op)     (assemble:op (rest ast))

    (:opX)    (assemble:opX (rest ast))

    (:proc)   (assemble:proc (rest ast))

    (:ref)    (concat (assemble (second ast))
                      '((:REF)))

    (:select) (assemble:selection (rest ast))

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

(defn assemble:proc [[params code info]]
  (list '(:PROC)
        params
        info
        (concat '((:SP_SAVE))
                (assemble code)
                '((:RET_P)))))

(defn assemble:selection [[from select where start connect stop group order limit as]]
  (with-local-vars [asm '((:SP_SAVE))]
    (let [FROM    (assemble:sel_from      from)
          SELECT  (assemble:sel_select    select)
          WHERE   (assemble:sel_where     where)
          START   (asm:loop start true)
          CONNECT ()
          STOP    ()
          ORDER   (assemble:sel_order     order)
          LIMIT   (assemble:sel_limit     limit)]
      (let [AS    (assemble:sel_as        as (second SELECT))
            GROUP (assemble:sel_group     group (second SELECT))]
        (var-set asm (concat @asm FROM))
        (var-set asm (concat @asm '((:IT_INIT))))

        (var-set asm (concat @asm START))

        (if (and (= as :val)
                 (= () WHERE GROUP))
          (var-set asm (concat @asm
                               '((:IT_NEXT0))
                               (first SELECT)
                               '((:IT_AS) 1)))
          (if (and (= as :val)
                   (empty GROUP)
                   (not-empty WHERE))
            (var-set asm (concat @asm
                                 AS
                                 '((:IT_NEXT0))
                                 '((:FJUMP_FW_X) 2)
                                 WHERE
                                 (first SELECT)
                                 '((:IT_AS) 1)
                                 '((:JUMP_END))))
            (if (and (not= as :val)
                     (= () GROUP ORDER LIMIT))
              (var-set asm (concat @asm
                                   AS
                                   '((:IT_NEXT0))
                                   '((:FJUMP_BK_X) 5 -5)
                                   WHERE
                                   (first SELECT)
                                   (list '(:IT_AS) (as as_value))
                                   '((:JUMP_END))))
              (var-set asm (concat @asm
                                   '((:IT_NEXT0))
                                   '((:FJUMP_BK_X) 5 -5)
                                   WHERE
                                   '((:IT_STORE))
                                   LIMIT
                                   '((:JUMP_END))
                                   ORDER
                                   AS
                                   (if (= :val as)
                                     '((:IT_NEXT1))
                                     '((:IT_NEXT3) (:FJUMP_BK_X) 5 -5))
                                   (first SELECT)
                                   (list '(:IT_AS) (as as_value))
                                   (if (= :val as)
                                     ()
                                     '((:JUMP_END)))
                                   GROUP)))))

        (var-set asm (concat @asm '((:RET))))
        @asm))))
        ;SELECT
        ;WHERE
        ;START
        ;CONNECT
        ;STOP
        ;GROUP
        ;ORDER
        ;LIMIT
        ;AS

(defn assemble:sel_as [type ids]
  (case type
    :set    (list '(:CST_SET) 0)
    :dict   (concat (loop [i ids asm ()]
                      (if (empty? i)
                        asm
                        (recur (rest i)
                               (concat asm (list '(:CST_LST) 0)))))
                    (list '(:CST_DCT) ids))
    :list   (list '(:CST_LST) 0)
    :val    '((:CST_N))
    :void   '((:CST_N))))


(defn assemble:sel_from [elements]
  (with-local-vars [expr (), ids ()]
    (loop [elem elements]
      (var-set ids  (concat @ids  [(first elem)]))
      (var-set expr (concat @expr (assemble (second elem))))
      (let [next_elems (nthrest elem 2)]
        (if (not-empty next_elems)
          (recur next_elems))))
    (concat @expr '((:CST_DCT)) (list @ids))))

(defn assemble:sel_select [elements]
  (with-local-vars [expr (), ids ()]
    (loop [elem elements]
      (var-set ids  (concat @ids  [(first elem)]))
      (var-set expr (concat @expr (assemble (second elem))))
      (let [next_elems (nthrest elem 2)]
        (if (not-empty next_elems)
          (recur next_elems))))
    [@expr @ids]))

(defn assemble:sel_where [ast]
  (if (empty? ast)
    ()
    (concat '((:FJUMP_WHERE))
            (assemble ast)
            '((:JUMP_END)))))

(defn assemble:sel_limit [ast]
  (if (empty? ast)
    ()
    (concat (assemble ast)
            '((:IT_LIMIT)))))

(defn assemble:sel_group [ast, ids]
  (if (empty? ast)
    ()
    (concat '((:CST_DCT) ())
            '((:IT_NEXT3))
            '((:FJUMP_BK_X) 5 -5)
            (assemble ast)
            (list '(:IT_GROUP) (count ids))
            '((:JUMP_END)))))

(defn assemble:sel_order [ast]
  (loop [elem ast rslt ()]
    (if (empty? elem)
      rslt
      (let [[expr dir] (first elem)
            asm_expr (assemble expr)]
        (concat rslt
                '((:CST_0))
                '((:IT_ORDER))
                '((:FJUMP_BK_X) 5 -5)
                '((:IT_NEXT1))
                asm_expr
                '((:IT_NEXT2))
                asm_expr
                '((:CALL_OP))
                (if (= dir :asc)
                  '(:lt 1)
                  '(:gt 1))
                '((:JUMP_END)))))))


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
      (if (and (list? elem)
               (.contains (keys OP) (first elem)))
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
