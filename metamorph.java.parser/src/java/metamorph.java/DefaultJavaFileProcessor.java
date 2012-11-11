package metamorph.java;

import metamorph.parsing.PrintingListener;
import org.antlr.v4.runtime.*;

import java.io.IOException;
import java.io.PrintWriter;

public final class DefaultJavaFileProcessor implements JavaFileProcessor {

    public void processFile(String filename) {
        ANTLRInputStream input = null;
        try {
            input = new ANTLRFileStream(filename);
            sourceToAst(input, new PrintWriter(System.out));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sourceToAst(ANTLRInputStream input, PrintWriter out) {
        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        ParserRuleContext<Token> tree = parser.compilationUnit();
        out.println(tree.toStringTree(parser));

        PrintingListener printingListener = new PrintingListener();

        return printingListener.toStringTree(tree, parser);

//        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
//        walker.walk(tree, new PrintingListener(out));
// ExtractInterfaceListener extractor = new ExtractInterfaceListener(parser);
// walker.walk(extractor, tree); // initiate walk of tree with listener
    }
}
