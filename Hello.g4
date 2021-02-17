grammar Hello;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

prog: (decl | expr)+ 
    ;

decl: TR | FR
    ;
 
expr: RB expr LB
    |expr TR expr
    |expr FR expr
    |expr AND expr
    | expr OR expr
    | expr Neg expr
    | expr IMP expr
    | expr IFF expr        //double imply 
    | expr FORALL expr
    |expr EXISTS expr
    /* add next, until, eventually, always */
   /* 
    * |expr NEXT expr
    * |expr UNTIL expr
    * |expr EVENT expr
    * |expr ALWAYS expr
    */ 
    ;

 //operators
  LB: ')';
 RB: '(';
TR: 'true';
 FR: 'false';
 AND: '&&';
 OR: '||';
 Neg: '!'; 
 IMP: '->';
 IFF:  '<=>';
 // first order operators 
FORALL : 'forall';
EXISTS : 'exists';
/* add next, until, eventually, always */
 /* 
  * NEXT: 'X';
  * UNTIL: 'U';
  * EVENT: 'F';
  * ALWAYS: 'G';
  */
