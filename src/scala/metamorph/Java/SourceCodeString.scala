package metamorph.Java

import org.antlr.v4.runtime.ANTLRInputStream
import io.Source
import collection.mutable
import metamorph.util.{Signature, AbsolutePath}

class InMemoryEditor(code: SourceCode) extends CodeEditor {
  var lines: mutable.MutableList[String] = new mutable.MutableList[String]() ++ (code.source.getLines())

  def replace(line: Int, startOffset: Int, length: Int, replacement: String) {
    // ANTLR line numbers start at 1 we have a 0 indexed list
    val lineText = lines(line - 1)

    val left = lineText.substring(0, startOffset)
    val right = lineText.substring(startOffset + length)

    lines(line - 1) = left + replacement + right
    lines.drop(line)
  }

  def renameFile(filename: String) {
    code.rename(filename)
  }

  def text = {
    lines.foldLeft("")((a, b) => a + b + "\n")
  }
}

class SourceCodeString(var text: String) extends SourceCode {
  def antlrStream = new ANTLRInputStream(text)

  def source = Source.fromString(text)

  def absolutePath = AbsolutePath.Invalid

  var name = "STRING"

  def branchPath = {
    throw new UnsupportedOperationException
  }

  def signature = Signature.fromString(text)

  def sourceName = "STRING SOURCE"

  def edit(function: (CodeEditor) => Unit) {
    val editor = new InMemoryEditor(this)

    function(editor)

    text = editor.text
  }

  def rename(name: String) {
    this.name = name
  }
}
