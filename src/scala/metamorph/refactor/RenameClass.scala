package metamorph.refactor

import metamorph.Java.{CodeEditor, JavaBaseVisitor}
import org.antlr.v4.runtime.tree.ParseTree
import metamorph.Java.JavaParser.ClassDeclarationContext
import org.antlr.v4.runtime.Token


class PackageDeclaration {

}

class ImportDeclaration {

}

class TypeDeclaration {

}

class CompilationUnit(val packageDeclaration: PackageDeclaration,
                      val imports: List[ImportDeclaration],
                      val types: List[TypeDeclaration]) {
}

class RenameClass(currentName: String, newName: String) extends CodeChange {

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

  def visitJava(editor: CodeEditor, tree: ParseTree) {
    val visitor = new RenameClassVisitor(editor, currentName, newName)

    visitor.visit(tree)
  }
}
