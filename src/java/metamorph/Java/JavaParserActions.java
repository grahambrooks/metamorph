package metamorph.Java;

import org.antlr.v4.runtime.Token;

import java.util.List;

public interface JavaParserActions {
    public void importDeclaration(Token importToken, List<Token> qualifiedName);
}
