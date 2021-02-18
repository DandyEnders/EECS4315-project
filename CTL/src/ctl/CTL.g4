// Define a grammar called Hello
grammar CTL;

/* Formula */

root 	: formula*;

formula	: state
		| path
		;

path 	: '(' path ')'					#PathBracket
		| X state 						#Next	// TODO: X should bind stronger than &&
		| F state						#Eventually
		| G state						#Always
		| <assoc=right> state U state 	#Until
		;

state 	: '(' state ')'						#StateBracket
		| A path							#ForAll
		| E path							#Exists
		| NEG state							#Not
		| TRUE								#True
		| FALSE								#False
		| ATOMIC_PROPOSITION				#AtomicProposition
		| <assoc=left> state WEDGE state 	#And
		| <assoc=right> state VEE state		#Or
		| <assoc=right> state TO state		#Implies
		| <assoc=right> state EQUIV state	#Iff
		;


/* Constants */
 

TRUE	:	('true' | 'True' )	; 
FALSE	:	('false' | 'False')	;

/* Letters */

E		:	'E'	;
A		:	'A'	;
X		:	'X'	;
U		:	'U'	;
F		: 	'F'	;
G 		: 	'G'	; 
WEDGE	:	'&&';
VEE		:	'||';
NEG		:	'!'	;
TO		:	'->';
EQUIV	:	'<->';

/* Expression */

ATOMIC_PROPOSITION	: [a] ; // TODO
PACKAGE_NAME		: [p] ; // TODO
CLASS_NAME			: [c] ; // TODO
FIELD_NAME			: [f] ; // TODO

/* Rules */
WS : [ \t\r\n;]+ -> skip ; // skip spaces and tabs
