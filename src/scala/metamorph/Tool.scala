package metamorph

import Java._
import java.io.File
import model.{MethodDeclaration, CodeModel}

object Tool {
  def main(args: Array[String]) {
    val tool = new Tool(new DefaultJavaFileProcessor(), new ConsoleWriter, new ConsoleReportWriter)

    tool.run(args)
  }
}

class Tool(processor: JavaFileProcessor, val console: ConsoleWriter, val reportWriter: ReportWriter) {
  def run(args: Array[String]) {
    var models: List[CodeModel] = Nil

    args foreach (arg => {
      scanFiles(arg, path => {
        val originalSource = new SourceCodeFile(path)

        val reader = new SourceCodeReader(originalSource)

        val model = reader.read

        models = models ::: List(model)
      })
    })

    analyse(models, reportWriter)
  }

  def scanFiles(pathOrFilename: String, function: (File) => Any) {
    try {
      val root = new File(pathOrFilename)

      val scanner = new DirectoryScanner(root.getCanonicalPath, ".*\\.java")

      scanner eachFile function
    }
    catch {
      case ae: Exception => console Error ae.getMessage
    }
  }

  private def analyse(models: List[CodeModel], writer: ReportWriter) {
    val methodBuckets = bucketMethods(models)

    writer.duplicateMethodBlock(writer => methodBuckets.eachDuplicate(methods => reportDuplicates(methods, writer)))
  }

  private def reportDuplicates(methods: List[MethodDeclaration], writer: ReportWriter) {
    writer.methodSummary(methods(0).name, methods.size)
    methods foreach (method => {
      writer.methodDetail(method.source.getFilename)
    })
  }

  private def bucketMethods(models: List[CodeModel]): Bucket[MethodDeclaration] = {
    val methodBuckets = new Bucket[MethodDeclaration]
    models foreach (model => {
      model.methods foreach (method => methodBuckets.add(method.syntaxSignature, method))
    })
    methodBuckets
  }
}
