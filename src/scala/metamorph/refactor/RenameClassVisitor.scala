package metamorph.refactor

import metamorph.Java.{JavaBaseVisitor, CodeEditor}
import metamorph.Java.JavaParser.ClassDeclarationContext
import org.antlr.v4.runtime.Token

class RenameClassVisitor(editor: CodeEditor, currentName: String, newName: String) extends JavaBaseVisitor[Object] {
  override def visitClassDeclaration(ctx: ClassDeclarationContext) = {
    if (currentName == ctx.Identifier().getText) {
      editor.renameFile(newName + ".java")
      val classNameToken: Token = ctx.Identifier().getSymbol
      editor.replace(classNameToken.getLine, classNameToken.getCharPositionInLine, classNameToken.getText.length, newName)
    }
    super.visitClassDeclaration(ctx)
  }
}
