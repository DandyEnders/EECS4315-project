grammar CTL;

/* Formula */
 
root 	: formula*;       

formula	: '(' formula ')'						#Bracket
		| NEG formula							#Not 
		| TRUE									#True
		| FALSE									#False
//		| ATOMIC_PROPOSITION					#AtomicProposition
		| atomic								#AtomicProposition
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


//atomic : (PACKAGE_NAME DOT)+ CLASS_NAME DOT FIELD_NAME;
atomic	: (STRING DOT)+ STRING	;
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

STRING	:	CHAR+		; 
/* Expression */
//PACKAGE_NAME		: LOWERSTRING; // TODO
//CLASS_NAME			: ([A-Z]STRING)  ; // TODO

//ATOMIC_PROPOSITION	: [a] ;  
FIELD_NAME			: STRING; // TODO

//LOWERCHARWITHDOT	:	[a-z.]	;
//LOWERSTRINGWITHDOT:	LOWERCHARWITHDOT+;
//LOWERCHAR	:	[a-z]	;
//LOWERSTRING:	LOWERCHAR+;
CHAR	:	'a'..'z' 
			| 'A'..'Z'	;
CAP		:	[A-Z]		;

DOT		:	'.' 		;	  
/* Rules */

WS : [ \t\r\n;]+ -> skip ; // skip spaces and tabs
