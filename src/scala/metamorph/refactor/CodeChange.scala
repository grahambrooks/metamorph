package metamorph.refactor

import org.antlr.v4.runtime.tree.ParseTree
import metamorph.Java.CodeEditor

trait CodeChange {
  def visitJava(editor: CodeEditor, tree: ParseTree)
}
