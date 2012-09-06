// $ANTLR 3.4 CodeR.Runtime/src/antlr/Ast.g 2012-09-05 22:19:52

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class AstLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public AstLexer() {} 
    public AstLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public AstLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "CodeR.Runtime/src/antlr/Ast.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CodeR.Runtime/src/antlr/Ast.g:2:7: ( '(' )
            // CodeR.Runtime/src/antlr/Ast.g:2:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CodeR.Runtime/src/antlr/Ast.g:3:7: ( ')' )
            // CodeR.Runtime/src/antlr/Ast.g:3:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CodeR.Runtime/src/antlr/Ast.g:4:7: ( ':' )
            // CodeR.Runtime/src/antlr/Ast.g:4:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CodeR.Runtime/src/antlr/Ast.g:5:7: ( 'charPositionInLine' )
            // CodeR.Runtime/src/antlr/Ast.g:5:9: 'charPositionInLine'
            {
            match("charPositionInLine"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CodeR.Runtime/src/antlr/Ast.g:6:7: ( 'index' )
            // CodeR.Runtime/src/antlr/Ast.g:6:9: 'index'
            {
            match("index"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CodeR.Runtime/src/antlr/Ast.g:7:7: ( 'line' )
            // CodeR.Runtime/src/antlr/Ast.g:7:9: 'line'
            {
            match("line"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CodeR.Runtime/src/antlr/Ast.g:8:7: ( 'text' )
            // CodeR.Runtime/src/antlr/Ast.g:8:9: 'text'
            {
            match("text"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CodeR.Runtime/src/antlr/Ast.g:9:7: ( 'type' )
            // CodeR.Runtime/src/antlr/Ast.g:9:9: 'type'
            {
            match("type"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CodeR.Runtime/src/antlr/Ast.g:17:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // CodeR.Runtime/src/antlr/Ast.g:17:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // CodeR.Runtime/src/antlr/Ast.g:17:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // CodeR.Runtime/src/antlr/Ast.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CodeR.Runtime/src/antlr/Ast.g:20:5: ( ( '0' .. '9' )+ )
            // CodeR.Runtime/src/antlr/Ast.g:20:7: ( '0' .. '9' )+
            {
            // CodeR.Runtime/src/antlr/Ast.g:20:7: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // CodeR.Runtime/src/antlr/Ast.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CodeR.Runtime/src/antlr/Ast.g:23:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // CodeR.Runtime/src/antlr/Ast.g:23:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CodeR.Runtime/src/antlr/Ast.g:31:5: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
            // CodeR.Runtime/src/antlr/Ast.g:31:8: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // CodeR.Runtime/src/antlr/Ast.g:31:12: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\\') ) {
                    alt3=1;
                }
                else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '[')||(LA3_0 >= ']' && LA3_0 <= '\uFFFF')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // CodeR.Runtime/src/antlr/Ast.g:31:14: ESC_SEQ
            	    {
            	    mESC_SEQ(); 


            	    }
            	    break;
            	case 2 :
            	    // CodeR.Runtime/src/antlr/Ast.g:31:24: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CodeR.Runtime/src/antlr/Ast.g:34:5: ( '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\'' )
            // CodeR.Runtime/src/antlr/Ast.g:34:8: '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 

            // CodeR.Runtime/src/antlr/Ast.g:34:13: ( ESC_SEQ |~ ( '\\'' | '\\\\' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\\') ) {
                alt4=1;
            }
            else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '&')||(LA4_0 >= '(' && LA4_0 <= '[')||(LA4_0 >= ']' && LA4_0 <= '\uFFFF')) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // CodeR.Runtime/src/antlr/Ast.g:34:15: ESC_SEQ
                    {
                    mESC_SEQ(); 


                    }
                    break;
                case 2 :
                    // CodeR.Runtime/src/antlr/Ast.g:34:25: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // CodeR.Runtime/src/antlr/Ast.g:39:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // CodeR.Runtime/src/antlr/Ast.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // CodeR.Runtime/src/antlr/Ast.g:43:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt5=1;
                    }
                    break;
                case 'u':
                    {
                    alt5=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt5=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // CodeR.Runtime/src/antlr/Ast.g:43:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 

                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // CodeR.Runtime/src/antlr/Ast.g:44:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 


                    }
                    break;
                case 3 :
                    // CodeR.Runtime/src/antlr/Ast.g:45:9: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // CodeR.Runtime/src/antlr/Ast.g:50:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\\') ) {
                int LA6_1 = input.LA(2);

                if ( ((LA6_1 >= '0' && LA6_1 <= '3')) ) {
                    int LA6_2 = input.LA(3);

                    if ( ((LA6_2 >= '0' && LA6_2 <= '7')) ) {
                        int LA6_4 = input.LA(4);

                        if ( ((LA6_4 >= '0' && LA6_4 <= '7')) ) {
                            alt6=1;
                        }
                        else {
                            alt6=2;
                        }
                    }
                    else {
                        alt6=3;
                    }
                }
                else if ( ((LA6_1 >= '4' && LA6_1 <= '7')) ) {
                    int LA6_3 = input.LA(3);

                    if ( ((LA6_3 >= '0' && LA6_3 <= '7')) ) {
                        alt6=2;
                    }
                    else {
                        alt6=3;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // CodeR.Runtime/src/antlr/Ast.g:50:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // CodeR.Runtime/src/antlr/Ast.g:51:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // CodeR.Runtime/src/antlr/Ast.g:52:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // CodeR.Runtime/src/antlr/Ast.g:57:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // CodeR.Runtime/src/antlr/Ast.g:57:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 

            match('u'); 

            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNICODE_ESC"

    public void mTokens() throws RecognitionException {
        // CodeR.Runtime/src/antlr/Ast.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | ID | INT | WS | STRING | CHAR )
        int alt7=13;
        switch ( input.LA(1) ) {
        case '(':
            {
            alt7=1;
            }
            break;
        case ')':
            {
            alt7=2;
            }
            break;
        case ':':
            {
            alt7=3;
            }
            break;
        case 'c':
            {
            int LA7_4 = input.LA(2);

            if ( (LA7_4=='h') ) {
                int LA7_13 = input.LA(3);

                if ( (LA7_13=='a') ) {
                    int LA7_18 = input.LA(4);

                    if ( (LA7_18=='r') ) {
                        int LA7_23 = input.LA(5);

                        if ( (LA7_23=='P') ) {
                            int LA7_28 = input.LA(6);

                            if ( (LA7_28=='o') ) {
                                int LA7_33 = input.LA(7);

                                if ( (LA7_33=='s') ) {
                                    int LA7_35 = input.LA(8);

                                    if ( (LA7_35=='i') ) {
                                        int LA7_36 = input.LA(9);

                                        if ( (LA7_36=='t') ) {
                                            int LA7_37 = input.LA(10);

                                            if ( (LA7_37=='i') ) {
                                                int LA7_38 = input.LA(11);

                                                if ( (LA7_38=='o') ) {
                                                    int LA7_39 = input.LA(12);

                                                    if ( (LA7_39=='n') ) {
                                                        int LA7_40 = input.LA(13);

                                                        if ( (LA7_40=='I') ) {
                                                            int LA7_41 = input.LA(14);

                                                            if ( (LA7_41=='n') ) {
                                                                int LA7_42 = input.LA(15);

                                                                if ( (LA7_42=='L') ) {
                                                                    int LA7_43 = input.LA(16);

                                                                    if ( (LA7_43=='i') ) {
                                                                        int LA7_44 = input.LA(17);

                                                                        if ( (LA7_44=='n') ) {
                                                                            int LA7_45 = input.LA(18);

                                                                            if ( (LA7_45=='e') ) {
                                                                                int LA7_46 = input.LA(19);

                                                                                if ( ((LA7_46 >= '0' && LA7_46 <= '9')||(LA7_46 >= 'A' && LA7_46 <= 'Z')||LA7_46=='_'||(LA7_46 >= 'a' && LA7_46 <= 'z')) ) {
                                                                                    alt7=9;
                                                                                }
                                                                                else {
                                                                                    alt7=4;
                                                                                }
                                                                            }
                                                                            else {
                                                                                alt7=9;
                                                                            }
                                                                        }
                                                                        else {
                                                                            alt7=9;
                                                                        }
                                                                    }
                                                                    else {
                                                                        alt7=9;
                                                                    }
                                                                }
                                                                else {
                                                                    alt7=9;
                                                                }
                                                            }
                                                            else {
                                                                alt7=9;
                                                            }
                                                        }
                                                        else {
                                                            alt7=9;
                                                        }
                                                    }
                                                    else {
                                                        alt7=9;
                                                    }
                                                }
                                                else {
                                                    alt7=9;
                                                }
                                            }
                                            else {
                                                alt7=9;
                                            }
                                        }
                                        else {
                                            alt7=9;
                                        }
                                    }
                                    else {
                                        alt7=9;
                                    }
                                }
                                else {
                                    alt7=9;
                                }
                            }
                            else {
                                alt7=9;
                            }
                        }
                        else {
                            alt7=9;
                        }
                    }
                    else {
                        alt7=9;
                    }
                }
                else {
                    alt7=9;
                }
            }
            else {
                alt7=9;
            }
            }
            break;
        case 'i':
            {
            int LA7_5 = input.LA(2);

            if ( (LA7_5=='n') ) {
                int LA7_14 = input.LA(3);

                if ( (LA7_14=='d') ) {
                    int LA7_19 = input.LA(4);

                    if ( (LA7_19=='e') ) {
                        int LA7_24 = input.LA(5);

                        if ( (LA7_24=='x') ) {
                            int LA7_29 = input.LA(6);

                            if ( ((LA7_29 >= '0' && LA7_29 <= '9')||(LA7_29 >= 'A' && LA7_29 <= 'Z')||LA7_29=='_'||(LA7_29 >= 'a' && LA7_29 <= 'z')) ) {
                                alt7=9;
                            }
                            else {
                                alt7=5;
                            }
                        }
                        else {
                            alt7=9;
                        }
                    }
                    else {
                        alt7=9;
                    }
                }
                else {
                    alt7=9;
                }
            }
            else {
                alt7=9;
            }
            }
            break;
        case 'l':
            {
            int LA7_6 = input.LA(2);

            if ( (LA7_6=='i') ) {
                int LA7_15 = input.LA(3);

                if ( (LA7_15=='n') ) {
                    int LA7_20 = input.LA(4);

                    if ( (LA7_20=='e') ) {
                        int LA7_25 = input.LA(5);

                        if ( ((LA7_25 >= '0' && LA7_25 <= '9')||(LA7_25 >= 'A' && LA7_25 <= 'Z')||LA7_25=='_'||(LA7_25 >= 'a' && LA7_25 <= 'z')) ) {
                            alt7=9;
                        }
                        else {
                            alt7=6;
                        }
                    }
                    else {
                        alt7=9;
                    }
                }
                else {
                    alt7=9;
                }
            }
            else {
                alt7=9;
            }
            }
            break;
        case 't':
            {
            switch ( input.LA(2) ) {
            case 'e':
                {
                int LA7_16 = input.LA(3);

                if ( (LA7_16=='x') ) {
                    int LA7_21 = input.LA(4);

                    if ( (LA7_21=='t') ) {
                        int LA7_26 = input.LA(5);

                        if ( ((LA7_26 >= '0' && LA7_26 <= '9')||(LA7_26 >= 'A' && LA7_26 <= 'Z')||LA7_26=='_'||(LA7_26 >= 'a' && LA7_26 <= 'z')) ) {
                            alt7=9;
                        }
                        else {
                            alt7=7;
                        }
                    }
                    else {
                        alt7=9;
                    }
                }
                else {
                    alt7=9;
                }
                }
                break;
            case 'y':
                {
                int LA7_17 = input.LA(3);

                if ( (LA7_17=='p') ) {
                    int LA7_22 = input.LA(4);

                    if ( (LA7_22=='e') ) {
                        int LA7_27 = input.LA(5);

                        if ( ((LA7_27 >= '0' && LA7_27 <= '9')||(LA7_27 >= 'A' && LA7_27 <= 'Z')||LA7_27=='_'||(LA7_27 >= 'a' && LA7_27 <= 'z')) ) {
                            alt7=9;
                        }
                        else {
                            alt7=8;
                        }
                    }
                    else {
                        alt7=9;
                    }
                }
                else {
                    alt7=9;
                }
                }
                break;
            default:
                alt7=9;
            }

            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '_':
        case 'a':
        case 'b':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'j':
        case 'k':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt7=9;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt7=10;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt7=11;
            }
            break;
        case '\"':
            {
            alt7=12;
            }
            break;
        case '\'':
            {
            alt7=13;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 7, 0, input);

            throw nvae;

        }

        switch (alt7) {
            case 1 :
                // CodeR.Runtime/src/antlr/Ast.g:1:10: T__13
                {
                mT__13(); 


                }
                break;
            case 2 :
                // CodeR.Runtime/src/antlr/Ast.g:1:16: T__14
                {
                mT__14(); 


                }
                break;
            case 3 :
                // CodeR.Runtime/src/antlr/Ast.g:1:22: T__15
                {
                mT__15(); 


                }
                break;
            case 4 :
                // CodeR.Runtime/src/antlr/Ast.g:1:28: T__16
                {
                mT__16(); 


                }
                break;
            case 5 :
                // CodeR.Runtime/src/antlr/Ast.g:1:34: T__17
                {
                mT__17(); 


                }
                break;
            case 6 :
                // CodeR.Runtime/src/antlr/Ast.g:1:40: T__18
                {
                mT__18(); 


                }
                break;
            case 7 :
                // CodeR.Runtime/src/antlr/Ast.g:1:46: T__19
                {
                mT__19(); 


                }
                break;
            case 8 :
                // CodeR.Runtime/src/antlr/Ast.g:1:52: T__20
                {
                mT__20(); 


                }
                break;
            case 9 :
                // CodeR.Runtime/src/antlr/Ast.g:1:58: ID
                {
                mID(); 


                }
                break;
            case 10 :
                // CodeR.Runtime/src/antlr/Ast.g:1:61: INT
                {
                mINT(); 


                }
                break;
            case 11 :
                // CodeR.Runtime/src/antlr/Ast.g:1:65: WS
                {
                mWS(); 


                }
                break;
            case 12 :
                // CodeR.Runtime/src/antlr/Ast.g:1:68: STRING
                {
                mSTRING(); 


                }
                break;
            case 13 :
                // CodeR.Runtime/src/antlr/Ast.g:1:75: CHAR
                {
                mCHAR(); 


                }
                break;

        }

    }


 

}