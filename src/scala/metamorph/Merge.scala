package metamorph

import Java._
import model.{MethodDeclaration, CodeModel}
import java.io.PrintWriter

class AnalysedSourceCode() {

}

class SourceCodeAnalyser {
  def analyse(models: List[CodeModel]): AnalysedSourceCode = {
    val typeBuckets = new BucketSet[CodeModel]()

    models.foreach(cm => typeBuckets.add(cm.typeSignature, cm))

    var duplicateMethods = Map[Signature, MethodDeclaration]()

    typeBuckets.duplicates().foreach(bucketWithDuplicates => {
      // Find a common subset of methods shared between each of the identified duplicates
      duplicateMethods = duplicateMethods ++ bucketWithDuplicates.bucket.foldLeft(Map[Signature, MethodDeclaration]()) {
        (map, cm) => {
          map ++ cm.methods.foldLeft(Map[Signature, MethodDeclaration]()) {
            (m, method) => if (m.contains(method.syntaxSignature)) m else Map(method.syntaxSignature -> method) ++ m
          }
        }
      }
    })

    duplicateMethods.foreach {
      case (sig: Signature, methodDecl: MethodDeclaration) => printf("Duplicate Methods shared by similar types %s", methodDecl.getName)
    }
    new AnalysedSourceCode()
  }
}

class Merge(importMap: Map[String, String]) {
  def merge(sources: List[SourceCode], destination: DestinationCode) {

    var codeModels = List[CodeModel]()

    sources.foreach(cm => codeModels = List(modelFromSource(cm)) ::: codeModels)

    val sourceSignatures = codeModels.foldLeft(List[Signature]()) {
      (r, c) => c.signature :: r
    }
    val uniqueSources = sourceSignatures.foldLeft(List[Signature]()) {
      (r, c) => if (r.contains(c)) r else c :: r
    }.reverse

    if (uniqueSources.size == 1) {
      copy(sources(0), destination)
    }

    val analyser = new SourceCodeAnalyser

    analyser.analyse(codeModels)

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
