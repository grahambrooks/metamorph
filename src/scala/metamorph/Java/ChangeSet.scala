package metamorph.Java

import metamorph.model.{ImportSpec, CodeModel}
import java.io.PrintWriter

class ChangeSet(model: CodeModel) {
  var packageSpec: PackageSpec = null
  var imports: List[ImportSpec] = Nil

  def setPackage(packageSpec: PackageSpec) {
    this.packageSpec = packageSpec
  }

  def add(im: ImportSpec) {
    imports = imports ::: List(im)
  }

  def writeImports(output: PrintWriter) {
    imports foreach (x => output.println("import " + x.qualifiedName + ";"))
  }

  def apply(code: CodeLine, output: PrintWriter) {
    if (packageSpec != null && model.packageLine == code.lineNumber) {
      output.println("package " + packageSpec.toString + ";")
      if (model.packageDeclaration == null && code.printable) {
        output.println(code.lineText)
      }
    } else {
      if (code.lineNumber == model.importInsertionPoint) {
        writeImports(output)
      }

      if (code.printable)
        output.println(code.lineText)
    }
  }

}
