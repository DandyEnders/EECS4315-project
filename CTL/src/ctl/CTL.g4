// Define a grammar called Hello
grammar CTL;

/* Formula */

root	: stopper? (formula stopper)*;

formula	: state 
		| path
		;

state 	: TRUE
		| FALSE
		| NEG state
		| ATOMIC_PROPOSITION
		| state WEDGE<assoc=left> state
		| state VEE state
		| state TO<assoc=right> state
		| state EQUIV state
		| A path
		| E path
		| '(' state ')'
		;

path 	: X state
		| F state
		| G state
		| state U<assoc=right> state
		| '(' path ')'
		;

/* Constants */
 

TRUE	:	('true' | 'True')	;
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

ATOMIC_PROPOSITION	: [a] ;
PACKAGE_NAME		: [p] ;
CLASS_NAME			: [c] ;
FIELD_NAME			: [f] ;

/* Rules */
WS : [ \t]+ -> skip ; // skip spaces and tabs

stopper	: '\r'?'\n' | ';' | <EOF> ;

