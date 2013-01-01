package metamorph.Java

import java.io.PrintWriter

class SourceCodeReWriter(code: SourceCode) {
  def rewrite(changes: ChangeSet, output: PrintWriter) {
    startOfFileChanges(changes, output)

    var i = 1
    code.source.getLines().foreach {
      line => changes.apply(new CodeLine {
        val lineText = line
        val lineNumber = i
        val printable = true
      }, output)

      i += 1
    }
  }

  def startOfFileChanges(changes: ChangeSet, output: PrintWriter) {
    changes.apply(new CodeLine {
      val lineText = ""
      val lineNumber = 0
      val printable = false
    }, output)
  }
}
