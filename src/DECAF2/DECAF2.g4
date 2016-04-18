grammar DECAF2;
// Adolfo Morales 13014, Decaf

// keywords

CLASSX: 'class';
STRUCTX: 'struct';
TRUEX: 'true';
FALSEX: 'false';
VOIDX:'void';
IFX: 'if';
ELSEX: 'else';
WHILEX: 'while';
RETURNX: 'return';
INTX: 'int';
CHARX: 'char';
BOOLEANX: 'boolean';
fragment LETTERX: ('A'..'Z'|'a'..'z');
fragment DIGITX: '0'..'9';
fragment VARX: (' '..'~')| '\\' | '\t' | '\n' ;
IDX: LETTERX (LETTERX | DIGITX)*;
NUMX: DIGITX (DIGITX)*;
CHARY: '\''(LETTERX | DIGITX |' '| '!' | '"' | '#' | '$' | '%' | '&' | '\'' | '(' | ')' | '*' 
| '+' | ',' | '-' | '.' | '/' | ':' | ';' | '<' | '=' | '>' | '?' | '@' | '[' | '\\' | ']' 
| '^' | '_' | '`'| '{' | '|' | '}' | '~' '\t'| '\n' | '\"' | '\''|EOF)'\'';
SPACEX: (' '|'\n'|'\t'|'\f'|'\r\n'|'\r'){skip();}; 
COMMENTX: '//'(~('\r'|'\n'))*{skip();}; 
COMAX: ',';
WS: [\t\n\r ]+{skip();};
AND: '&&';
OR: '||';


// GRAMATICA DECAF AUMENTADA 

programa: CLASSX IDX '{' declaration* '}';
	
declaration: structDeclaration|varDeclaration|methodDeclaration;

varDeclaration: 
            varType IDX ';'                 #simpleVarDeclaration
            | varType IDX '[' NUMX ']' ';'  #ArrayVarDeclaration
            ;

structDeclaration: STRUCTX IDX '{' varDeclaration* '}';

varType: INTX| CHARX | BOOLEANX | STRUCTX IDX | structDeclaration  | VOIDX;

methodDeclaration: methodType IDX '('  (parameter (COMAX parameter)*)? ')' block ;

methodType: INTX | CHARX | BOOLEANX | VOIDX ;

parameter: parameterType IDX | parameterType IDX '['NUMX ']';

parameterType: INTX | CHARX | BOOLEANX ;

block: '{' (varDeclaration | statement)* '}';


statement:  ifS
    |whileS
    |returnS  
    |methodCall ';' 
    |block 
    |assign
    |(expression)? ';';
		   
assign: location '=' expression ';';

ifS: IFX '(' expression ')' block ( elseS)? ;   

elseS: ELSEX block;

returnS: RETURNX  (expressionNueva) ';' ;

whileS: WHILEX '(' expression ')' block ;
		   
		 
location: simpleLocation| structLocation ;

structLocation: simpleVariable ('.' location)
			| arrayVariable ('.' location) ;
	
simpleLocation: simpleVariable | arrayVariable ;

simpleVariable: 	IDX;			

arrayVariable: IDX '[' expression ']' ;

exp1: '(' expression ')';

// Expression 
		
expressionNueva: expression | ;

expression : andExpr                    
        | expression OR andExpr         
        ;

andExpr: eqExpr                         #SimpleEqExpr
        | andExpr AND eqExpr            #AndConditionExpr
        ;

eqExpr: relationExpr                    #SimpleRelationExpr
        | eqExpr eq_op relationExpr     #EqIneqExpr
        ; 

relationExpr: addExpr                   #SimpleAddExpr
        | relationExpr rel_op addExpr   #ConditionalExpr
        ;

addExpr: multExpr                       #SimpleMultExpr
        | addExpr add_op multExpr       #AddDiffExpr
        ;

multExpr: unaryExpr                     #SimpleUnaryExpr
        | multExpr mult_op unaryExpr    #MultDivExpr
        ;

unaryExpr:  '('(INTX|CHARX)')'  value
         | '-' value
         | '!' value
         | value
         ;


value: location| methodCall| literal| exp1;

methodCall: IDX '(' (arg (COMAX arg)* )? ')';

arg: expression;

add_op: '+'| '-';
	
mult_op: '*' | '/' | '%' ;

rel_op: '<' | '>' | '<=' | '>=';

eq_op : '==' | '!=' ;

literal: int_literal | char_literal | bool_literal ;

int_literal: NUMX;

char_literal: CHARY ; 

bool_literal : TRUEX | FALSEX ;




