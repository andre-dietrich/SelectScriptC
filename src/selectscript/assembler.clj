(ns selectscript.assembler
  (:use [selectscript.compiler :only (OP op)]  :reload))

(declare assemble
         asm
         asm:dict
         asm:elem
         asm:exit
         asm:fct
         asm:if
         asm:list
         asm:loc
         asm:loop
         asm:op
         asm:opX
         asm:proc
         asm:ref
         asm:sql
         asm:sql_as
         asm:sql_from
         asm:sql_select
         asm:sql_where
         asm:sql_order
         asm:sql_group
         asm:sql_limit
         asm:try
         asm:set
         asm:val
         asm:var

         optimize
         seq:loop
         pop:add
         pop:rm)

(def as_value {:void 0 :val 1 :list 2 :set 4 :dict 3})

(defn assemble
  ([ast]     (assemble ast true))
  ([ast opt] (if opt
               (optimize (asm ast))
               (asm ast))))

(defn optimize
  ([code]       (optimize code []))
  ([code opt]   (if (empty? code)
                  opt
                  (case (first code)
                    [:CST_N     :POP] (optimize (rest code) opt)
                    [:CST_0     :POP] (optimize (rest code) opt)
                    [:CST_1     :POP] (optimize (rest code) opt)
                    [:CST_B     :POP] (optimize (nthrest code 2) opt)
                    [:CST_S     :POP] (optimize (nthrest code 2) opt)
                    [:CST_I     :POP] (optimize (nthrest code 2) opt)
                    [:CST_F     :POP] (optimize (nthrest code 2) opt)
                    [:CST_STR   :POP] (optimize (nthrest code 2) opt)
                    [:LOAD      :POP] (optimize (nthrest code 2) opt)
                    [:LOC       :POP] (optimize (nthrest code 2) opt)
                    [:STORE     :POP] (if (and (= [:LOAD] (nth code 2))
                                               (= (nth code 1) (nth code 3)))
                                        (optimize (nthrest code 3)
                                                  (concat opt '((:STORE))))
                                        (optimize (rest code)
                                                  (concat opt [(first code)])))
                    [:STORE_LOC :POP] (if (and (= [:LOC] (nth code 2))
                                               (= (nth code 1) (nth code 3)))
                                        (optimize (nthrest code 3)
                                                  (concat opt '((:STORE_LOC))))
                                        (optimize (rest code)
                                                  (concat opt [(first code)])))

                    (optimize   (rest code) (concat opt [(first code)]))))))

(defn asm [ast]
  (case (first ast)
    :dict   (asm:dict (second ast))
    :elem   (asm:elem (rest ast))
    :exit   (asm:exit (second ast))
    :fct    (asm:fct  (rest ast))
    :if     (asm:if   (rest ast))
    :list   (asm:list (second ast))
    :loc    (asm:loc  (rest ast))
    :loop   (asm:loop (second ast))
    :op     (asm:op   (rest ast))
    :opX    (asm:opX  (rest ast))
    :proc   (asm:proc (rest ast))
    :ref    (asm:ref  (second ast))
    :set    (asm:set  (second ast))
    :sql    (asm:sql  (rest ast))
    :try    (asm:try  (rest ast))
    :val    (asm:val  (second ast))
    :var    (asm:var  (second ast))

    (concat '((:SP_SAVE))
            (pop:rm (seq:loop ast true))
            '((:RET)))))


(defn asm:dict [dict]
  (concat (seq:loop (map second dict))
          (list '(:CST_DCT) (map first dict))))

(defn asm:elem [[p1 p2]]
  (concat (asm p1)
          (loop [elems [] code p2]
            (if (empty? code)
              elems
              (recur (concat elems
                             (asm (first code))
                             '((:ELEM)))
                     (rest code))))))

(defn asm:exit [ast]
  (concat (asm ast)
          '((:EXIT))))

(defn asm:fct [[id params]]
  (concat (seq:loop params)
          (asm id)
          '((:CALL_FCT))
          (list (count params))))

(defn asm:if [[if_ then_ else_]]
  (concat '((:SP_SAVE))
          (asm if_  ) '((:IF))
          (asm then_) '((:RET_X))
          (asm else_) '((:RET_X))
          '((:RET))))

(defn asm:loop [ast]
  (concat '((:SP_SAVE) (:LOOP_BEGIN))
          (if (list? (first ast))
            (seq:loop ast true)
            (pop:add (asm ast)))
          '((:RET_X) (:RET))))

(defn asm:list [ast]
  (concat (seq:loop ast)
          (list '(:CST_LST) (count ast))))

(defn asm:loc [[id extension]]
  (if (empty? extension)
    (list '(:LOC) id)
    (concat (asm extension)
            (list '(:LOCX) id))))

(defn asm:op [[op params]]
  (if (= op :assign)
    (case (first (first params))
      :var  (concat (seq:loop (rest  params)) '((:STORE))     [(second (first params))])
      :loc  (concat (seq:loop (rest  params)) '((:STORE_LOC)) [(second (first params))])
      :elem (concat (asm (first params))
                    (seq:loop (rest  params))
                    '((:STORE_RF))))
    (concat (seq:loop params)
            (list '(:CALL_OP)
                  op
                  (dec (count params))))))

(defn asm:opX [[op params]]
  (concat (seq:loop params)
          (list '(:CALL_OPX)
                 op
                 (dec (count params)))))

(defn asm:proc [[params code info]]
  (concat (asm params)
          '((:PROC))
          [info]
          [(concat '((:SP_SAVE))
                  (asm code)
                  '((:RET_P)))]))

(defn asm:ref [ast]
  (concat (asm ast)
         '((:REF))))

(defn asm:set [ast]
  (concat (seq:loop ast)
          (list '(:CST_SET) (count ast))))

(defn asm:sql [[from select where start connect stop group order limit as]]
  (with-local-vars [asm '((:SP_SAVE))]
    (let [FROM    (asm:sql_from      from)
          SELECT  (asm:sql_select    select)
          WHERE   (asm:sql_where     where)
          START   (seq:loop start true)
          CONNECT ()
          STOP    ()
          ORDER   (asm:sql_order     order)
          LIMIT   (asm:sql_limit     limit)]
      (let [AS    (asm:sql_as        as (second SELECT))
            GROUP (asm:sql_group     group (second SELECT))]
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
                                 '((:RET_X))))
            (if (and (not= as :val)
                     (= () GROUP ORDER LIMIT))
              (var-set asm (concat @asm
                                   AS
                                   '((:IT_NEXT0))
                                   '((:FJUMP_BK_X) 5 -5)
                                   WHERE
                                   (first SELECT)
                                   (list '(:IT_AS) (as as_value))
                                   '((:RET_X))))
              (var-set asm (concat @asm
                                   '((:IT_NEXT0))
                                   '((:FJUMP_BK_X) 5 -5)
                                   WHERE
                                   '((:IT_STORE))
                                   LIMIT
                                   '((:RET_X))
                                   ORDER
                                   AS
                                   (if (= :val as)
                                     '((:IT_NEXT1))
                                     '((:IT_NEXT3) (:FJUMP_BK_X) 5 -5))
                                   (first SELECT)
                                   (list '(:IT_AS) (as as_value))
                                   (if (= :val as)
                                     ()
                                     '((:RET_X)))
                                   GROUP)))))

        (var-set asm (concat @asm '((:RET))))
        @asm))))

(defn asm:sql_as [type ids]
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


(defn asm:sql_from [elements]
  (with-local-vars [expr (), ids ()]
    (loop [elem elements]
      (var-set ids  (concat @ids  [(first elem)]))
      (var-set expr (concat @expr (asm (second elem))))
      (let [next_elems (nthrest elem 2)]
        (if (not-empty next_elems)
          (recur next_elems))))
    (concat @expr '((:CST_DCT)) (list @ids))))

(defn asm:sql_select [elements]
  (with-local-vars [expr (), ids ()]
    (loop [elem elements]
      (var-set ids  (concat @ids  [(first elem)]))
      (var-set expr (concat @expr (asm (second elem))))
      (let [next_elems (nthrest elem 2)]
        (if (not-empty next_elems)
          (recur next_elems))))
    [@expr @ids]))

(defn asm:sql_where [ast]
  (if (empty? ast)
    ()
    (concat '((:FJUMP_WHERE))
            (asm ast)
            '((:RET_X)))))

(defn asm:sql_limit [ast]
  (if (empty? ast)
    ()
    (concat (asm ast)
            '((:IT_LIMIT)))))

(defn asm:sql_group [ast, ids]
  (if (empty? ast)
    ()
    (concat '((:CST_DCT) ())
            '((:IT_NEXT3))
            '((:FJUMP_BK_X) 5 -5)
            (asm ast)
            (list '(:IT_GROUP) (count ids))
            '((:RET_X)))))

(defn asm:sql_order [ast]
  (loop [elem ast rslt ()]
    (if (empty? elem)
      rslt
      (let [[expr dir] (first elem)
            asm_expr (asm expr)]
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
                  '(:LT 1)
                  '(:GT 1))
                '((:RET_X)))))))

(defn asm:try [[ast1 ast2]]
  (concat '((:SP_SAVE))
          '((:TRY_1))
          (asm ast1)
          '((:RET_X))
          (asm ast2)
          '((:RET_X))
          '((:RET))))

(defn asm:val [val]
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

(defn asm:var [ast]
  (list '(:LOAD) ast))

(defn seq:loop
  ([ast] (seq:loop ast false))
  ([ast pop] (let [assemble_ (if pop
                               (comp pop:add asm first)
                               (comp asm first))]
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
               ;(or (= :RET_X (first elem))
               (.contains (keys OP) (first elem)))
        (let [[left right] (split-at i code)]
          (concat left
                  (list (list (first elem) :POP))
                  (rest right)))
        (recur (dec i))))))

(defn pop:rm [code]
  (loop [i (dec (count code))]
    (let [elem (nth code i)]
      (if (and (list? elem)
               (= :POP (second elem)))
        (let [[left right] (split-at i code)]
          (concat left (list (list(first elem))) (rest right)))
        (recur (dec i))))))


;(asm (parse "f(); f();"))
