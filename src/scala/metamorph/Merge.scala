package metamorph

import Java._
import model.CodeModel
import java.io.PrintWriter

class Merge(importMap: Map[String, String]) {
  def merge(sources: List[SourceCode], destination: DestinationCode) {
    val sourceSignatures = sources.foldLeft(List[Signature]()) {
      (r, c) => modelFromSource(c).signature :: r
    }
    val uniqueSources = sourceSignatures.foldLeft(List[Signature]()) {
      (r, c) => if (r.contains(c)) r else c :: r
    }.reverse

    if (uniqueSources.size == 1) {
      copy(sources(0), destination)
    }
  }

  def copy(source: SourceCode, destination: DestinationCode) {
    val model: CodeModel = modelFromSource(source)
    if (importMap.contains(model.packageDeclaration.qualifiedName.name)) {
      val changeSet = new ChangeSet(model)

      changeSet.setPackage(new PackageSpec(importMap(model.packageDeclaration.qualifiedName.name)))

      applyChanges(source, changeSet, destination)
    }

  }

  private def applyChanges(source: SourceCode, changeSet: ChangeSet, destination: DestinationCode) {
    val writer = new SourceCodeReWriter(source)


    val output: PrintWriter = new PrintWriter(destination.getWriter)
    writer.rewrite(changeSet, output)
  }


  private def modelFromSource(originalSource: SourceCode): CodeModel = {
    val reader = new SourceCodeReader(originalSource)
    reader.read
  }

}
