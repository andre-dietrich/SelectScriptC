grammar SelectScript;

/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

DOT 	: '.';
SEP 	: ',';
END 	: ';';
COLON	: ':';
AD 		: '@' ;

AND 	: A N D ;
XOR 	: X O R ;
OR  	: O R   ;
NOT 	: N O T ;
IN  	: I N   ;

SHIFTR	: '>>' | 'irshift';
SHIFTL	: '<<' | 'ilshift';
IAND	: '&'  | 'iand';
IXOR	: '^'  | 'ixor';
IOR		: '|'  | 'ior';
INV		: '~'  | 'inv';

ASSIGN :  '=' ;

EQ	: '==' | 'eq' ;
NE	: '!=' | 'ne' ;
LE	: '<=' | 'le' ;
GE	: '>=' | 'ge' ;
LT	:  '<' | 'lt' ;
GT	:  '>' | 'gt' ;

ADD : '+'  | 'add';
SUB : '-'  | 'sub';
MUL : '*'  | 'mul';
DIV : '/'  | 'div';
MOD : '%'  | 'mod';
POW : '**' | 'pow';

IF	: I F ;

SQ 	: '\'';
DQ 	: '"';

LIST_BEGIN : '[' ;
LIST_END   : ']' ;

DICT_BEGIN : '{' ;
DICT_END   : '}' ;

//DOLLAR : '$';

PROCEDURE:  P R O C (E D U R E)? ;

SELECT : S E L E C T ;
FROM   : F R O M ;
WHERE  : W H E R E ;
ORDER  : O R D E R ;
GROUP  : G R O U P ;
HAVING : H A V I N G ;
BY     : B Y ;
LIMIT  : L I M I T ;
AS     : A S ;

LOC   : '$' ;

CONNECT: C O N N E C T ;
START  : S T A R T ;
STOP   : S T O P ;
WITH   : W I T H ;

NO      : N O ;
CYCLE   : C Y C L E ;
UNIQUE  : U N I Q U E ;
MEMORIZE: M E M O R I Z E ;
COST    : C O S T;

ASC    : A S C (E N D I N G)? ;
DESC   : D E S C (E N D I N G)? ;

//AS_SET  : S E T ;
//AS_LIST : L I S T ;
//AS_VALUE: V A L (U E)? ;
//AS_DICT	: D I C T (I O N A R Y)? ;
//AS_VOID : V O I D ;

DEL_F : 'del';
MEM_F : 'mem';
EVAL_F: 'eval';

LOOP: L O O P;
EXIT: E X I T;

TRY : T R Y;

REF : R E F;

NEWLINE	: ('\r'? '\n') -> skip ; // {self.skip()};
WS		: (' '|'\t'|'\n'|'\r')+ -> skip ; //{self.skip()} ;

COMMENT : '/*' .*? '*/' -> skip ;
LINE_COMMENT : '#' ~('\n'|'\r')* '\r'? '\n' -> skip ;

STRING	: DQ .*? DQ | SQ .*? SQ ;
FLOAT	: DIGIT* DOT DIGIT* ;
INTEGER
	: DIGIT+
	| '0b' ('0'|'1')+
	| '0o' ('0'..'7')+
	| '0x' (DIGIT | 'a'..'f' | 'A'..'F')+
;

TRUE	: ('T'|'t') ('R'|'r') ('U'|'u') ('E'|'e');
FALSE	: ('F'|'f') ('A'|'a') ('L'|'l') ('S'|'s') ('E'|'e');
NONE	: ('N'|'n') ('O'|'o') ('N'|'n') ('E'|'e');

IDENTIFIER : DIGIT? (CHARACTER | SPECIAL) (DIGIT | CHARACTER | SPECIAL)* ;

fragment DIGIT     : '0'..'9' ;
fragment CHARACTER : ('a'..'z' | 'A'..'Z') ;
fragment SPECIAL   : '_' | '?';

fragment A : ('A'|'a') ; fragment N : ('N'|'n') ;
fragment B : ('B'|'b') ; fragment O : ('O'|'o') ;
fragment C : ('C'|'c') ; fragment P : ('P'|'p') ;
fragment D : ('D'|'d') ; fragment Q : ('Q'|'q') ;
fragment E : ('E'|'e') ; fragment R : ('R'|'r') ;
fragment F : ('F'|'f') ; fragment S : ('S'|'s') ;
fragment G : ('G'|'g') ; fragment T : ('T'|'t') ;
fragment H : ('H'|'h') ; fragment U : ('U'|'u') ;
fragment I : ('I'|'i') ; fragment V : ('V'|'v') ;
fragment J : ('J'|'j') ; fragment W : ('W'|'w') ;
fragment K : ('K'|'k') ; fragment X : ('X'|'x') ;
fragment L : ('L'|'l') ; fragment Y : ('Y'|'y') ;
fragment M : ('M'|'m') ; fragment Z : ('Z'|'z') ;

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

prog
	: (elem_ += stmt END)+
;

assign
	: e1 = repository ASSIGN e2 = stmt
;

atom
	: repository
	| if_expr
	| try_expr
	| loop
	| reference
	| '(' elem_=stmt ')'
	| '(' prog_=prog ')'
;

dict
	: DICT_BEGIN elem_ += dict_elem
				(SEP elem_ += dict_elem)* DICT_END
;

dict_elem
	: id_ = dict_id COLON value_ = stmt
;

dict_id
	: str_ = STRING | id_ = IDENTIFIER
;

element
	: //elem_ = atom
	(       var_  = variable
	  |     loc_  = loc
	  | '(' stmt_ = stmt ')' )
	(
		( LIST_BEGIN stmt (SEP stmt)* LIST_END )
		|
		( DOT dict_id )+
	)+
;

exit
	: EXIT (stmt_ = stmt)?
;

expr
	:   (special | special2)		# ex_spec
	|  			MUL 	e1=expr		# ex_ex
	| 			NOT 	e1=expr		# ex_not
	| 			ADD 	e1=expr		# ex_pos
	| 			SUB 	e1=expr		# ex_neg
	| e1=expr	POW 	e2=expr		# ex_pow
	| e1=expr	(DIV
				|MOD
				|MUL)	e2=expr		# ex_div_mod_mul
	| e1=expr	(ADD
				|SUB)	e2=expr		# ex_add_sub
	| e1=expr	(SHIFTL
				|SHIFTR) e2=expr	# ex_shift
	| e1=expr 	IAND	e2=expr		# ex_iand
	| e1=expr	IXOR	e2=expr  	# ex_ixor
	| e1=expr	IOR		e2=expr		# ex_ior
	| 			INV		e1=expr		# ex_inot
 	| e1=expr 	LT		e2=expr		# ex_lt
	| e1=expr 	LE		e2=expr		# ex_le
	| e1=expr 	GE		e2=expr		# ex_ge
	| e1=expr 	GT		e2=expr		# ex_gt
 	| e1=expr 	NE		e2=expr		# ex_ne
 	| e1=expr 	IN		e2=expr		# ex_in
 	| e1=expr 	EQ		e2=expr		# ex_eq
	| e1=expr 	AND		e2=expr		# ex_and
	| e1=expr 	XOR		e2=expr		# ex_xor
	| e1=expr 	OR		e2=expr		# ex_or
	| ( atom
	  | value
	  | list
	  | dict
	  | set
	  | function)					# ex_else
;

function
	: del_ = function_del
	| mem_ = function_mem
	| repo_ = atom (AD extra_ = atom)? '(' (elem_ = stmt_list)? ')'
;

function_del
	: DEL_F '(' ((IDENTIFIER | STRING) (SEP (IDENTIFIER | STRING))*)? ')'
;

function_mem
	: MEM_F '(' (IDENTIFIER | STRING)? ')'
;

if_expr
	: IF '(' if_=stmt (SEP then_=stmt (SEP else_=stmt)?)? ')'
;

list
	: LIST_BEGIN (elem_ = stmt_list)? LIST_END
;

loc
	: (id_=IDENTIFIER)? LOC (LOC '(' extra_=stmt ')')?
;

loop
	: LOOP do_=stmt
;

procedure
	: PROCEDURE
	  ( '(' params_ = procedure_params ')' )?
	  (info_=STRING)?
	  COLON code_=stmt
;

procedure_params
	: ((IDENTIFIER | LOC | dict_elem) (SEP (IDENTIFIER | dict_elem))*)?
;

reference
	: REF elem=atom;

repository
	: variable
	| element
	| loc
;

selection
	: (select_= sel_select)?
	  (from_  = sel_from)
	  (where_ = sel_where)?

	  (start_ = sel_start)?
	  (connect_ = sel_connect stop_ = sel_stop)?

	  (order_ = sel_order)?
	  (group_ = sel_group)? //(h=having_)?)?
	  (limit_ = sel_limit)?
	  (as_    = sel_as)?
;

sel_as
	: AS   //( AS_LIST | AS_SET | AS_VALUE | AS_DICT | AS_VOID |
	  IDENTIFIER ('(' params_=stmt_list ')')?
;

sel_connect
	: CONNECT BY
		(NO CYCLE)?
		(UNIQUE)?
		(MEMORIZE mem_=stmt)?
		(COST cost_=stmt)?
		stmt_list
;

sel_dir
	: (ASC | DESC)
;

sel_from
	: FROM sel_list
;

sel_group
	: GROUP BY stmt_list
;

sel_limit
	: LIMIT expr
;

sel_list
	: (dict_elem | stmt) (SEP (dict_elem | stmt))*
;

sel_order
	: ORDER BY ( stmt sel_dir? ) ( SEP stmt sel_dir? )*
;

sel_select
	: SELECT sel_list
;

sel_start
	: START WITH stmt_list
;

sel_stop
	: STOP WITH stmt
;

sel_where
	: WHERE stmt
;

set
	: DICT_BEGIN (elem_=stmt_list)? DICT_END
;

special
	:
	( EQ  | NE  | LE  | GE  | LT  | GT
	| AND | OR  | XOR
	| ADD | SUB | MUL | DIV | MOD | POW
	| IN
	| IOR | IAND | IXOR
	| SHIFTR | SHIFTL )

	'(' elem_=stmt_list ')'
;

special2
	: repo_ = repository AD ( (NOT '(' ')') |
	                          (INV '(' ')') |
							  (ADD '(' ')') |
							  (SUB '(' ')') |
							  (op_=special) )
;

stmt
	: assign
	| expr
	| procedure
	| exit
	| selection
	| '(' seq_ = prog ')'
;

stmt_list
	: elem_ += stmt (SEP elem_ += stmt)*
;

try_expr
	: TRY '(' try_=stmt (SEP catch_=stmt)? ')'
;


value
	: str_   = STRING
	| float_ = FLOAT
	| int_   = INTEGER
	| true_  = TRUE
	| false_ = FALSE
	| none_  = NONE
;

variable
	: name_ = IDENTIFIER
;
