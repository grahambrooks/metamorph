package metamorph.Java

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.mock.MockitoSugar
import org.antlr.v4.runtime.ANTLRInputStream
import metamorph.java.DefaultJavaFileProcessor

class DefaultJavaFileProcessorSpec extends FlatSpec with ShouldMatchers with MockitoSugar {
  it should "generate a text representation of AST" in {
    processSource("") should equal("(compilationUnit <EOF>)")
  }

  it should "generate a text representation of AST for class declaration" in {
    processSource("class foo {}") should equal("(compilationUnit (typeDeclaration (classDeclaration class foo (classBody { }))) <EOF>)")
  }

  it should "generate a text representation of AST for method declaration" in {
    processSource("class foo { void m() {} }") should equal("(compilationUnit (typeDeclaration (classDeclaration class foo (classBody { (classBodyDeclaration modifiers (member (methodDeclaration void m (formalParameters ( )) (methodDeclarationRest (methodBody (block { })))))) }))) <EOF>)")
  }

  it should "generate a text representation of AST for method call" in {
    processSource("class foo { void m() { foo f = new foo(); f.m(); } }") should equal("(compilationUnit " +
      "(typeDeclaration " +
      "(classDeclaration class foo " +
      "(classBody { " +
      "(classBodyDeclaration modifiers " +
      "(member " +
      "(methodDeclaration void m (formalParameters ( )) " +
      "(methodDeclarationRest " +
      "(methodBody " +
      "(block { " +
      "(blockStatement " +
      "(localVariableDeclarationStatement " +
      "(localVariableDeclaration variableModifiers " +
      "(type " +
      "(classOrInterfaceType foo)) " +
      "(variableDeclarators " +
      "(variableDeclarator (variableDeclaratorId f) = (variableInitializer (expression new (creator (createdName (classOrInterfaceType foo)) (classCreatorRest (arguments ( ))))))))) ;)) " +
      "(blockStatement (statement (statementExpression (expression (expression (expression (primary f)) . m) ( ))) ;)) })))))) }))) <EOF>)")
  }

  def processSource(text: String): String = {
    val processor = new DefaultJavaFileProcessor

    val input = new ANTLRInputStream(text)

    val astText = processor.sourceToAst(input)
    print(astText)

    return astText
  }
}
