import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        AstLexer lex = new AstLexer(new ANTLRFileStream("/Users/graham/projects/CODER/CodeR.Runtime/src/antlr/output/__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        AstParser g = new AstParser(tokens, 49100, null);
        try {
            g.ast_tree();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}