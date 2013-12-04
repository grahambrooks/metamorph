package metamorph

import Java._
import parsing.{ParserFactory, RefactoringParser}
import refactor.CodeChange
import org.antlr.v4.runtime.{Token, CommonTokenStream}

class JavaRefactoringParser(changes: List[CodeChange]) extends RefactoringParser with JavaParserActions {

  def refactor(source: SourceCode) {
    val parser = new JavaParser(new CommonTokenStream(new JavaLexer(source.antlrStream)))
    parser.parserActions = this
    val tree = parser.compilationUnit

    changes.foreach(change => {
      source.edit(editor => change.visitJava(editor, tree))
    })
  }

  def importDeclaration(importToken: Token, nameTokens: java.util.List[Token]) {}

  def packageDeclaration(packageToken: Token, nameTokens: java.util.List[Token]) {}
}


object SupportedLanguages {
  def Java = new Language {
    def refactoringParser(changes: List[CodeChange]) = new JavaRefactoringParser(changes)

    def parser = new ParserFactory {
      def parse(code: SourceCode) = {
        new AntlrSourceCodeReader(code).read
      }
    }
  }
}
