package metamorph.Java;

import org.antlr.v4.runtime.Token;

import java.util.List;

public interface JavaParserActions {
    public void importDeclaration(Token importToken, List<Token> nameTokens);
    public void packageDeclaration(Token packageToken, List<Token> nameTokens);
    public void methodDeclaration(Token methodNameToken);
}
