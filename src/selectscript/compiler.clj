(ns selectscript.compiler
  (:use [selectscript.utils]    :reload))



(def op { :NOT    0, :NEG    1,
          :ADD    2, :SUB    3, :MUL    4,
          :DIV    5, :MOD    6, :POW    7,
          :LT     8, :LE     9, :GE    10,
          :GT    11, :NE    12, :EQ    13,
          :ID    14,
          :AND   15, :XOR   16, :OR    17,
          :IN    18,
          :B_NOT 19, :B_AND 20,
          :B_OR  21, :B_XOR 22,
          :LEFT  23, :RIGHT 24,
          :EX    25})

(def OP { :SP_SAVEX      0, :SP_SAVE     1,
          :RET           2, :RET_P       3,
          :CST_N         4,
          :CST_0         5,
          :CST_1         6,
          :CST_B         7,
          :CST_S         8,
          :CST_I         9,
          :CST_F        10,

          :CST_STR      11,
          :CST_LST      12,
          :CST_SET      13,
          :CST_DCT      14,

          :LOC          15,
          :LOCX         16,
          :LOAD         17,
          :ELEM         18,

          :STORE        19,
          :STORE_RF     20,
          :STORE_LOC    21,

          :CALL_FCTX    22,
          :CALL_FCT     23,

          :FJUMP        24,
          :JUMP         25,

          :PROC         26,

          :IT_INIT      27,
          :IT_NEXT0     28,
          :IT_NEXT1     29,
          :IT_NEXT2     30,
          :IT_NEXT3     31,
          :IT_STORE     32,
          :IT_LIMIT     33,

          :IT_GROUP     34,
          :IT_ORDER     35,
          :IT_AS        36,

          :EXIT         37,
          :REC_SET      38,

          :TRY_1        39,
          :TRY_0        40,

          :REF          41,

          :IT_INITX     42,
          :IT_STOREX    43,
          :CHK_FIRST    44,
          :RETX         45,
          :IT_STOREX2   46,
          :LOC_STEP     47,
          :LOC_COUNT    48,
          :IT_CYCLE     49,
          :IT_UNIQUE    50,

          :YIELD        51,
          :PROC_LOAD    52,

          :OP           64,
          :OPX          96})

(declare cmp
         cmp:cmd
         cmp:data

         cmp:base
         cmp:connect
         cmp:proc
         cmp:dict
         cmp:exit
         cmp:exit2
         cmp:recur
         cmp:store_loc
         cmp:str
         cmp:op
         cmp:loop
         cmp:if
         cmp:try
         cmp:jump_where
         cmp:jump_back
         cmp:jump_fwd
         cmp:sp_save
         cmp:pop

         cmp:yield

         cmp:return_fjump

         conc)


(defn cmp:cmd [cmd asm]
  (let [c (first cmd)
        p (= :POP (second cmd))]
    [c p (if (contains? OP c)
           (conc asm [(cmp:pop c p)])
           asm)]))

(defn cmp:pop [cmd pop]
  (+ (cmd OP)
     (if pop 128 0)))


(defn cmp:data [repo string]
  (let [pos (.indexOf repo string)]
    (if (< pos 0)
      [(conc repo [string]) (count repo)]
      [repo pos])))

(defn cmp:base [code data asm fct sp local_vars]
  (cmp (rest code)
       data
       (conc asm (fct (first code)))
       sp
       local_vars))

(defn cmp
  ([code] (let [[data asm] (cmp code [] [] -1 [])]
            (map #(if (< 127 %) (- % 256) %)
                 (conc [(:SP_SAVEX OP)]
                       (uint8->byte (count data))
                   (loop [d data bytes []]
                     (if (empty? d)
                       bytes
                       (recur (rest d)
                              (conc bytes (+ 2 (count (first d))) (string->byte (first d))))))
                   (cmp:exit2 (rest asm) 2)))))

  ([code data asm sp local_vars]
   ;(println "->>>>>" code data asm local_vars)
   (if (empty? code)
     [data asm]
     (let [[cmd pop asm_] (cmp:cmd (first code) asm)]
       (condp contains? cmd
         ;#{:IT_GROUP}     (cmp:base       (rest code) data asm_ uint8->byte  sp)
         #{:CST_B}        (cmp:base       (rest code) data asm_ int8->byte   sp local_vars)
         #{:CST_F}        (cmp:base       (rest code) data asm_ float->byte  sp local_vars)
         #{:CST_I}        (cmp:base       (rest code) data asm_ int32->byte  sp local_vars)
         #{:CST_S}        (cmp:base       (rest code) data asm_ int16->byte  sp local_vars)
         #{:CST_LST
           :CST_SET}      (cmp:base       (rest code) data asm_ uint16->byte sp local_vars)
         #{:CALL_FCTX
           :CALL_FCT
           :IT_GROUP}     (cmp:base       (rest code) data asm_ uint8->byte  sp local_vars)
         #{:CST_STR
           :LOAD
           :LOC
           :LOCX
           :STORE}        (cmp:str          (rest code) data asm_ sp local_vars)
         #{:STORE_LOC}    (cmp:store_loc    (rest code) data asm_ sp local_vars)
         #{:OP :OPX}      (cmp:op           (rest code) data asm_ sp local_vars)
         #{:LOOP_BEGIN}   (cmp:loop         (rest code) data asm_ sp local_vars)
         #{:EXIT}         (cmp:exit         (rest code) data asm_ sp local_vars)
         #{:IF}           (cmp:if           (rest code) data asm_ sp local_vars)
         #{:TRY_1}        (cmp:try          (rest code) data asm_ sp local_vars)
         #{:PROC}         (cmp:proc         (rest code) data asm_ sp local_vars)
         #{:CST_DCT}      (cmp:dict         (rest code) data asm_ sp local_vars)
         #{:RECUR}        (cmp:recur        (rest code) data asm_ sp local_vars)
         #{:SP_SAVE}      (cmp:sp_save      (rest code) data asm_ sp local_vars)
         #{:FJUMP_FW_X}   (cmp:jump_fwd     (rest code) data asm_ sp local_vars)
         #{:FJUMP_WHERE}  (cmp:jump_where   (rest code) data asm_ sp local_vars)
         #{:FJUMP_BK_X}   (cmp:jump_back    (rest code) data asm_ sp local_vars)
         #{:RETURN_FJUMP} (cmp:return_fjump (rest code) data asm_ sp local_vars)
         #{:CONNECT}      (cmp:connect      (rest code) data asm_ sp local_vars)
         #{:IT_AS}        (cmp (nthrest code 2) data (conc asm_ (second code)) sp local_vars)
         #{:IT_LIMIT}     (cmp (rest code) data (conc asm_ (:FJUMP OP) (int16->byte 5)) sp local_vars)
         #{:RET_X}        [(rest code) data asm_ local_vars]
         #{:RET
           :RET_L
           :RET_P}        [(rest code) data asm_ local_vars]
         (cmp (rest code) data asm_ sp local_vars))))))


(defn cmp:connect [[_begin _middle _end _p & code] data asm sp local_vars]
  (with-local-vars [data_ data
                    asm_begin [] asm_middle [] asm_end []]

    (let [c_begin   (cmp _begin @data_ [] sp local_vars)]
      (var-set data_     (nth c_begin 1))
      (var-set asm_begin (nth c_begin 2)))

    (let [c_middle  (cmp _middle @data_ [] sp local_vars)]
      (var-set data_      (nth c_middle 1))
      (var-set asm_middle (nth c_middle 2)))

    (let [c_end  (cmp _end @data_ [] sp local_vars)]
      (var-set data_   (nth c_end 1))
      (var-set asm_end (nth c_end 2)))

    (cmp code @data_
         (conc asm
               (:JUMP OP) (int16->byte (+ 7 (count @asm_begin)))
               (:SP_SAVE OP) '(:LOC_COUNTER)
               @asm_begin
               (:FJUMP OP) (int16->byte (+ 4 _p (count @asm_middle)))
               (butlast @asm_middle)
               (:JUMP OP) (int16->byte (- -5 _p (count @asm_middle) (count @asm_begin)))
               (:RETX OP)
               @asm_end
               (:JUMP OP) (int16->byte (- -9 _p (count @asm_middle))))
               ;(:RET OP))
         sp local_vars)))



(defn cmp:dict [[keys & code] data asm sp local_vars]
  (let [[new_data ids] (loop [d data, i [], k keys]
                         (if (empty? k)
                           [d i]
                           (let [[D I] (cmp:data d (first k))]
                             (recur D (conc i [I]) (rest k)))))]
    (cmp code
         new_data
         (conc asm (uint16->byte (count ids)) ids)
         sp
         local_vars)))

(defn cmp:exit [code data asm sp local_vars]
  (cmp code
       data
       (conc asm (uint8->byte sp) [:JUMP_FORWARD 0 0])
       sp
       local_vars))


(defn cmp:if [code data asm sp local_vars]
  (let [then (cmp code data [] sp local_vars)]
    (let [else (cmp (first then) (second then) [] sp local_vars)]
      (let [count_then (count (nth then 2))
            count_else (count (nth else 2))]
        (cmp (first else)
             (second else)
             (conc asm
                   (if (and (< 0 count_then)
                            (< 0 count_else))
                     (conc [(:FJUMP OP)]
                           (int16->byte (+ 5 count_then))
                           (nth then 2)
                           (:JUMP OP)
                           (int16->byte (+ 2 count_else))
                           (nth else 2))
                     (if (zero? count_else)
                       (conc [(:FJUMP OP)]
                             (int16->byte (+ 2 count_then))
                             (nth then 2))
                       (conc [(:FJUMP OP)]
                             (int16->byte (+ 2 count_else))
                             (nth else 2)))))
             sp
             local_vars)))))

(defn cmp:jump_back [code data asm sp local_vars]
  (let [overhead1 (first  code)
        overhead2 (second code)
        new (cmp (nthrest code 2) data [] sp local_vars)]
    (cmp (first new)
         (second new)
         (concat asm
                 [(:FJUMP OP)]
                 (int16->byte (+ overhead1 (count (nth new 2))))
                 (nth new 2)
                 [(:JUMP OP)]
                 (int16->byte (- overhead2 (count (nth new 2)))))
         sp
         local_vars)))


(defn cmp:jump_fwd [code data asm sp local_vars]
  (let [overhead (first code)
        new (cmp (rest code) data () sp local_vars)]
    (cmp (first new)
         (second new)
         (concat asm
                 [(:FJUMP OP)]
                 (int16->byte (+ (count (nth new 2)) overhead))
                 (nth new 2))
         sp
         local_vars)))

(defn cmp:return_fjump [code data asm sp local_vars]
  (let [overhead (first code)
        new (cmp (rest code) data () sp local_vars)]
    (cmp (first new)
         (second new)
         (concat asm
                 (nth new 2)
                 [(:FJUMP OP)
                  (int16->byte (- overhead (count (nth new 2))))])
         sp
         local_vars)))


(defn cmp:jump_where [code data asm sp local_vars]
  (let [new (cmp code data [] sp local_vars)]
    (cmp (first new)
         (second new)
         (concat asm
                 (nth new 2)
                 [(:FJUMP OP)]
                 (int16->byte (- (- (count (nth new 2))) 5)))
         sp
         local_vars)))

(defn cmp:exit2 [a x]
  (loop [asm a, asm2 []]
    (if (empty? asm)
      asm2
      (recur (if (or (= :JUMP_FORWARD (first asm))
                     (= :JUMP_BACK (first asm)))
               (nthrest asm 3)
               (rest asm))
             (conc asm2 (if (= :JUMP_FORWARD (first asm))
                          (conc [(:JUMP OP)] (int16->byte (- (count a)
                                                             (count asm2)
                                                             x)))
                          (if (= :JUMP_BACK (first asm))
                            (conc [(:JUMP OP)] (int16->byte (- (count asm)
                                                               (count a)
                                                               -2
                                                               x)))
                            (first asm))))))))

(defn cmp:loop [code data asm sp local_vars]
  (let [loop_ (cmp code data [] 0 local_vars)]
    (let [asm_ (cmp:exit2 (nth loop_ 2) -2)]
      (cmp (first loop_)
           (second loop_)
           (conc asm
                 asm_
                 (:JUMP OP)
                 (int16->byte (- -1 (count asm_))))
           sp
           local_vars))))


(defn cmp:op [[operation params & code] data asm sp local_vars]
  (cmp code
       data
       (conc (drop-last asm)
             [(+ (last asm) (operation op))]
             (uint8->byte params))
       sp
       local_vars))


(defn cmp:proc [[info code_proc & code] data asm sp local_vars]
  (let [[i_data, i_id] (cmp:data data info)
        proc_asm (cmp code_proc)]
    (cmp code
         i_data
         (conc asm
               (uint8->byte i_id)
               (uint16->byte (count proc_asm))
               proc_asm)
         sp
         local_vars)))

(defn cmp:recur [code data asm sp local_vars]
  (cmp code
       data
       (conc asm
             (:REC_SET OP) (uint8->byte sp)
             [:JUMP_BACK 0 0])
       sp
       local_vars))

(defn cmp:sp_save [code data asm sp local_vars]
  (let [[c d a l] (cmp code data [] (inc sp) local_vars)]
    (let [l_count (count (nthrest l (count local_vars)))]
      (cmp c
           d
           (conc asm
                 l_count
                 (map #(if (= :LOC_COUNTER %) l_count %) a))
           sp
           local_vars))))

(defn cmp:store_loc [code data asm sp local_vars]
  (let [[data_ i] (cmp:data data (first code))]
    (cmp code data_ (conc asm i) sp (if (.contains local_vars i)
                                      local_vars
                                      (conc local_vars i)))))


(defn cmp:str [code data asm sp local_vars]
  (let [[data_ i] (cmp:data data (first code))]
    (cmp:base (conj (rest code) i) data_ asm list sp local_vars)))

(defn cmp:try [code data asm sp local_vars]
  (let [try_code (cmp code data [] sp local_vars)]
    (let [catch_code (cmp (first try_code) (second try_code) [] sp local_vars)]
      (cmp (first  catch_code)
           (second catch_code)
           (conc  asm
                  (int16->byte (+ 4 (count (nth try_code 2))))
                  (nth try_code 2)
                  (:TRY_0 OP)
                  (:JUMP OP)
                  (int16->byte (+ 2 (count (nth catch_code 2))))
                  (nth catch_code 2))
           sp
           local_vars))))



(defn conc [a & b]
  (if (empty? b)
    a
    (recur (let [element (first b)]
             (if (integer? element)
               (conj a element)
               (into [] (concat a element))))
           (rest b))))
