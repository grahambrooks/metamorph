grammar Ast;

@header {
    package CodeR.Ast;
}

@lexer::header
{
    package CodeR.Ast;
}

ast_tree
	:	ast_node
	;

ast_node returns [AstNode n = new AstNode()]
	:	'('
			'type' ':' type=INT { $n.setType(Integer.parseInt($type.getText())); }
			'line' ':' line=INT { $n.setLine(Integer.parseInt($line.getText())); }
			'charPositionInLine' ':' posn=INT { $n.setCharPositionInLine(Integer.parseInt($posn.getText())); }
			'text' ':' text=STRING { $n.setText($text.getText().substring(1, $text.getText().length() - 1)); }
			'index' ':' index=INT { $n.setIndex(Integer.parseInt($index.getText())); }
		(child = ast_node { $n.addChild(child); })* ')'
	;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
