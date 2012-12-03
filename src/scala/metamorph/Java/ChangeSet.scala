package metamorph.Java

import metamorph.model.{CodeModel, Import}
import java.io.PrintWriter

class ChangeSet(model: CodeModel) {
  var imports: List[Import] = Nil

  def add(im: Import) {
    imports = imports ::: List(im)
  }

  def writeImports(output: PrintWriter) {
    imports foreach (x => output.println("import " + x.qualifiedName + ";"))
  }

  def apply(code: CodeLine, output: PrintWriter) {
    if (code.lineNumber == model.importInsertionPoint) {
      writeImports(output)
    }
    if (code.printable)
      output.print(code.lineText)
  }

}
