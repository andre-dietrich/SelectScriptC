grammar SelectScript;

/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

DOT 	: '.';
SEP 	: ',';
END 	: ';';
COLON	: ':';

AND 	: A N D ;
XOR 	: X O R ;
OR  	: O R   ;
NOT 	: N O T ;
IN  	: I N   ;

IRSHIFT	: '>>' | 'irshift';
ILSHIFT	: '<<' | 'ilshift';
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

AGE : '@' ;

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

AS_SET  : S E T ;
AS_LIST : L I S T ;
AS_VALUE: V A L (U E)? ;
AS_DICT	: D I C T (I O N A R Y)? ;
AS_VOID : V O I D ;

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
	: repo_ = repo ASSIGN value_ = stmt
;

atom
	: value
	| repo
	| function
	| list
	| dict
	| set
	| '(' stmt ')'
;

dict
	: DICT_BEGIN elem_ += dict_elem
				(SEP elem_ += dict_elem)* DICT_END
;

dict_elem
	: (str_ = STRING | id_ = IDENTIFIER) COLON value_ = stmt
;


function
	: repo_ = repo '(' (params_ = stmt_list)? ')'
;

list
	: LIST_BEGIN (params_ = stmt_list)? LIST_END
;

repo
	: name_ = IDENTIFIER
;

set
	: DICT_BEGIN (elem_=stmt_list)? DICT_END
;

stmt
	: assign
	| atom
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
