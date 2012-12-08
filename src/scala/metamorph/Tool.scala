package metamorph

import Java._
import java.io.File
import model.{MethodDeclaration, CodeModel}
import collection.mutable

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

  def analyse(models: List[CodeModel], writer: ReportWriter) {
    val methodBuckets = bucketMethods(models)

    methodBuckets.values foreach (methods => {
      if (hasDuplicates(methods)) {
        writer.println(methods(0).name + " has " + (methods.size - 1) + " duplicates")
        methods foreach(method => {
          writer.println(method.source.getFilename)
        })
      }
    })
  }

  def bucketMethods(models: List[CodeModel]) :mutable.HashMap[Signature, List[MethodDeclaration]] = {
    val methodBuckets = new mutable.HashMap[Signature, List[MethodDeclaration]]
    models foreach (model => {
      model.methods foreach (method => {
        if (methodBuckets.contains(method.syntaxSignature)) {
          methodBuckets(method.syntaxSignature) :::= List(method)
        } else {
          methodBuckets(method.syntaxSignature) = List(method)
        }
      })
    })
    methodBuckets
  }

  private def hasDuplicates(methods: List[MethodDeclaration]): Boolean = {
    methods.size > 1
  }
}
