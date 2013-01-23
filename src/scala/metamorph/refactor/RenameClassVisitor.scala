package metamorph.refactor

import metamorph.Java.{JavaBaseVisitor, CodeEditor}
import metamorph.Java.JavaParser.{FieldDeclarationContext, ImportDeclarationContext, ClassDeclarationContext}
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.ParseTree

class RenameClassVisitor(editor: CodeEditor, currentName: String, newName: String) extends JavaBaseVisitor[Object] {
  override def visitFieldDeclaration(ctx: FieldDeclarationContext) = {

    val coi = ctx.`type`().classOrInterfaceType()

    if (coi != null) {
      if (coi.Identifier(coi.Identifier().size()-1).getText == currentName) {
        val token = coi.Identifier(coi.Identifier().size()-1).getSymbol

        editor.replace(token.getLine, token.getCharPositionInLine, token.getText.length, newName)
      }
    }

    super.visitFieldDeclaration(ctx)
  }

  override def visitImportDeclaration(ctx: ImportDeclarationContext) = {
    var qualifiedNameTokens = List[Token]()

    eachToken(ctx.qualifiedName(), token => {
      qualifiedNameTokens = qualifiedNameTokens ::: List(token)
    })

    val qualifiedName = qualifiedNameTokens.foldLeft("") {
      (acc, n) => acc + n.getText
    }

    val className = qualifiedNameTokens.last.getText

    if (qualifiedName == currentName || className == currentName) {
      val importPath = qualifiedNameTokens.take(qualifiedNameTokens.length - 1).foldLeft("") {
        (acc, n) => acc + n.getText
      }

      val replacementText = "import " + importPath + newName + ";"

      editor.replace(ctx.start.getLine, ctx.start.getCharPositionInLine, ctx.stop.getCharPositionInLine + ctx.stop.getText.length, replacementText)
    }

    super.visitImportDeclaration(ctx)
  }

  override def visitClassDeclaration(ctx: ClassDeclarationContext) = {
    if (currentName == ctx.Identifier().getText) {
      editor.renameFile(newName + ".java")
      val classNameToken: Token = ctx.Identifier().getSymbol
      editor.replace(classNameToken.getLine, classNameToken.getCharPositionInLine, classNameToken.getText.length, newName)
    }
    super.visitClassDeclaration(ctx)
  }

  private def eachToken(tree: ParseTree, function: (Token) => Unit) {
    if (tree != null) {
      if (tree.getPayload != null) {
        if (tree.getPayload.isInstanceOf[Token]) {
          function(tree.getPayload.asInstanceOf[Token])
        }
      }

      for (i <- 0 until tree.getChildCount) {
        val child: ParseTree = tree.getChild(i)

        eachToken(child, function)
      }
    }
  }
}
