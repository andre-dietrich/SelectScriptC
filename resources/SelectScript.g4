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

DOLLAR : '$';

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

LOC   : L O C ;

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

REF : 'ref';

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
	: repo_ = repository ASSIGN value_ = stmt
;

atom
	: repository
	| function
	| if_expr
	| list
	| dict
	| set
	| '(' elem_=stmt ')'
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
	: (     var_  = variable
	  | '(' stmt_ = stmt ')' )

	(
		( LIST_BEGIN stmt (SEP stmt)* LIST_END )
		|
		( DOT dict_id )+
	)+
;

expr
	:  			MUL 	e1=expr		# ex_ex
	| 			NOT 	e1=expr		# ex_not
	| 			ADD 	e1=expr		# ex_pos
	| 			SUB 	e1=expr		# ex_neg
	| e1=expr	POW 	e2=expr		# ex_pow
	| e1=expr	DIV		e2=expr		# ex_div
	| e1=expr	MOD		e2=expr		# ex_mod
	| e1=expr	MUL		e2=expr		# ex_mul
	| e1=expr	ADD		e2=expr		# ex_add
	| e1=expr	SUB		e2=expr		# ex_sub
	| e1=expr	SHIFTL	e2=expr		# ex_left
	| e1=expr	SHIFTR	e2=expr		# ex_right
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
	  | value )						# ex_else
;

function
	: repo_ = repository (COLON extra_ = repository)? '(' (elem_ = stmt_list)? ')'
;

if_expr
	: IF '(' if_=stmt (SEP then_=stmt (SEP else_=stmt)?)? ')'
;


list
	: LIST_BEGIN (elem_ = stmt_list)? LIST_END
;

repository
	: variable
	| element
;

set
	: DICT_BEGIN (elem_=stmt_list)? DICT_END
;

stmt
	: assign
	| expr
	| '(' seq_ = prog ')'
;

stmt_list
	: elem_ += stmt (SEP elem_ += stmt)*
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
