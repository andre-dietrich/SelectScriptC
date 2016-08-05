(ns selectscript.compiler
    (:use [selectscript.parser] :reload)
)

(def op [       :not     ;  0
                :neg     ;  1

                :add     ;  2
                :sub     ;  3
                :mul     ;  4
                :div     ;  5
                :mod     ;  6
                :pow     ;  7

                :lt      ;  8
                :le      ;  9
                :ge      ; 10
                :gt      ; 11
                :ne      ; 12
                :eq      ; 13

                :and     ; 14
                :xor     ; 15
                :or      ; 16
                :in      ; 17

                :inv     ; 18
                :iand    ; 19
                :ior     ; 20
                :ixor    ; 21
                :ilshift ; 22
                :irshift ; 23

                :ex])    ; 24

(def op_code [  :RET          ;  0
                :RET_L        ;  1
                :RET_P        ;  2
                :SP_SAVE      ;  3

                :CST_N        ;  4
                :CST_0        ;  5
                :CST_1        ;  6
                :CST_B        ;  7
                :CST_S        ;  8
                :CST_I        ;  9
                :CST_F        ; 10

                :CST_STR      ; 11
                :CST_LST      ; 12
                :CST_SET      ; 13
                :CST_DCT      ; 14

                :LOAD         ; 15
                :ELEM         ; 16
                :STORE        ; 17
                :STORE_RF     ; 18
                :STORE_LOC    ; 19

                :CALL_OPX     ; 20
                :CALL_OP      ; 21

                :CALL_FCTX    ; 22
                :CALL_FCT     ; 23

                :FJUMP        ; 24
                :JUMP         ; 25

                :PROC         ; 26
                :LOC          ; 27
                :LOCX         ; 28

                :IT_INIT      ; 29
                :IT_NEXT0     ; 30
                :IT_NEXT1     ; 31
                :IT_NEXT2     ; 32
                :IT_NEXT3     ; 33
                :IT_STORE     ; 34
                :IT_LIMIT     ; 35
                :IT_GROUP     ; 36
                :IT_ORDER     ; 37
                :IT_AS        ; 38

                :EXIT         ; 39

                :TRY          ; 40
                :REF])        ; 41
