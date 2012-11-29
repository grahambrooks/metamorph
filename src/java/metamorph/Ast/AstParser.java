// $ANTLR 3.4 metamorph.runtime/src/antlr/Ast.g 2012-11-12 14:56:13

    package metamorph.Ast;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class AstParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHAR", "ESC_SEQ", "HEX_DIGIT", "ID", "INT", "OCTAL_ESC", "STRING", "UNICODE_ESC", "WS", "'('", "')'", "':'", "'charPositionInLine'", "'index'", "'line'", "'text'", "'type'"
    };

    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int CHAR=4;
    public static final int ESC_SEQ=5;
    public static final int HEX_DIGIT=6;
    public static final int ID=7;
    public static final int INT=8;
    public static final int OCTAL_ESC=9;
    public static final int STRING=10;
    public static final int UNICODE_ESC=11;
    public static final int WS=12;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public AstParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public AstParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return AstParser.tokenNames; }
    public String getGrammarFileName() { return "metamorph.runtime/src/antlr/Ast.g"; }



    // $ANTLR start "ast_tree"
    // metamorph.runtime/src/antlr/Ast.g:12:1: ast_tree : ast_node ;
    public final void ast_tree() throws RecognitionException {
        try {
            // metamorph.runtime/src/antlr/Ast.g:13:2: ( ast_node )
            // metamorph.runtime/src/antlr/Ast.g:13:4: ast_node
            {
            pushFollow(FOLLOW_ast_node_in_ast_tree26);
            ast_node();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "ast_tree"



    // $ANTLR start "ast_node"
    // metamorph.runtime/src/antlr/Ast.g:16:1: ast_node returns [AstNode n = new AstNode()] : '(' 'type' ':' type= INT 'line' ':' line= INT 'charPositionInLine' ':' posn= INT 'text' ':' text= STRING 'index' ':' index= INT (child= ast_node )* ')' ;
    public final AstNode ast_node() throws RecognitionException {
        AstNode n =  new AstNode();


        Token type=null;
        Token line=null;
        Token posn=null;
        Token text=null;
        Token index=null;
        AstNode child =null;


        try {
            // metamorph.runtime/src/antlr/Ast.g:17:2: ( '(' 'type' ':' type= INT 'line' ':' line= INT 'charPositionInLine' ':' posn= INT 'text' ':' text= STRING 'index' ':' index= INT (child= ast_node )* ')' )
            // metamorph.runtime/src/antlr/Ast.g:17:4: '(' 'type' ':' type= INT 'line' ':' line= INT 'charPositionInLine' ':' posn= INT 'text' ':' text= STRING 'index' ':' index= INT (child= ast_node )* ')'
            {
            match(input,13,FOLLOW_13_in_ast_node41); 

            match(input,20,FOLLOW_20_in_ast_node46); 

            match(input,15,FOLLOW_15_in_ast_node48); 

            type=(Token)match(input,INT,FOLLOW_INT_in_ast_node52); 

             n.setType(Integer.parseInt(type.getText())); 

            match(input,18,FOLLOW_18_in_ast_node59); 

            match(input,15,FOLLOW_15_in_ast_node61); 

            line=(Token)match(input,INT,FOLLOW_INT_in_ast_node65); 

             n.setLine(Integer.parseInt(line.getText())); 

            match(input,16,FOLLOW_16_in_ast_node72); 

            match(input,15,FOLLOW_15_in_ast_node74); 

            posn=(Token)match(input,INT,FOLLOW_INT_in_ast_node78); 

             n.setCharPositionInLine(Integer.parseInt(posn.getText())); 

            match(input,19,FOLLOW_19_in_ast_node85); 

            match(input,15,FOLLOW_15_in_ast_node87); 

            text=(Token)match(input,STRING,FOLLOW_STRING_in_ast_node91); 

             n.setText(text.getText().substring(1, text.getText().length() - 1)); 

            match(input,17,FOLLOW_17_in_ast_node98); 

            match(input,15,FOLLOW_15_in_ast_node100); 

            index=(Token)match(input,INT,FOLLOW_INT_in_ast_node104); 

             n.setIndex(Integer.parseInt(index.getText())); 

            // metamorph.runtime/src/antlr/Ast.g:23:3: (child= ast_node )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // metamorph.runtime/src/antlr/Ast.g:23:4: child= ast_node
            	    {
            	    pushFollow(FOLLOW_ast_node_in_ast_node115);
            	    child=ast_node();

            	    state._fsp--;


            	     n.addChild(child); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input,14,FOLLOW_14_in_ast_node121); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "ast_node"

    // Delegated rules


 

    public static final BitSet FOLLOW_ast_node_in_ast_tree26 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ast_node41 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ast_node46 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ast_node48 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_INT_in_ast_node52 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ast_node59 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ast_node61 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_INT_in_ast_node65 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ast_node72 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ast_node74 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_INT_in_ast_node78 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ast_node85 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ast_node87 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_STRING_in_ast_node91 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ast_node98 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ast_node100 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_INT_in_ast_node104 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_ast_node_in_ast_node115 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ast_node121 = new BitSet(new long[]{0x0000000000000002L});

}