package metamorph.refactor

import metamorph.Java.CodeEditor
import org.antlr.v4.runtime.tree.ParseTree


class RenameClass(val currentName: String, val newName: String) extends CodeChange {
  def visitJava(editor: CodeEditor, tree: ParseTree) {
    val visitor = new RenameClassVisitor(editor, currentName, newName)

    visitor.visit(tree)
  }
}
