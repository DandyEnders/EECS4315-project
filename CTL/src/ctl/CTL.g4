grammar CTL;

/* Formula */

root 	: formula*;

formula	: '(' formula ')'						#Bracket
		| NEG formula							#Not
		| TRUE									#True
		| FALSE									#False
		| ATOMIC_PROPOSITION					#AtomicProposition
		| A X formula							#ForAllNext
		| A F formula							#ForAllEventually
		| A G formula							#ForAllAlways
		| <assoc=right> A formula U formula		#ForAllUntil
		| E X formula							#ExistsNext
		| E F formula							#ExistsEventually
		| E G formula							#ExistsAlways
		| <assoc=right> E formula U formula		#ExistsUntil
		| <assoc=left> formula WEDGE formula 	#And
		| <assoc=right> formula VEE formula		#Or
		| <assoc=right> formula TO formula		#Implies
		| <assoc=right> formula EQUIV formula	#Iff
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
