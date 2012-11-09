package metamorph.java;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.PrintWriter;

public final class DefaultJavaFileProcessor implements JavaFileProcessor {

    public void processFile(String filename) {
        ANTLRInputStream input = null;
        try {
            input = new ANTLRFileStream(filename);
            sourceToAst(input, new PrintWriter(System.out));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void sourceToAst(ANTLRInputStream input, PrintWriter out) {
        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        ParserRuleContext<Token> tree = parser.compilationUnit(); // parse
        out.println(tree.toStringTree(parser));
        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
        walker.walk(tree, new PrintingListener(out));
// ExtractInterfaceListener extractor = new ExtractInterfaceListener(parser);
// walker.walk(extractor, tree); // initiate walk of tree with listener
    }
}
