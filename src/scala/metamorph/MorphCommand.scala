package metamorph

import Java.{SourceCodeReader, SourceCodeFile}
import model.{MethodDeclaration, CodeModel}
import java.io.File

trait MorphCommand {
  def run(config: MorphConfig, processor: SourceCodeFileProcessor, console: ConsoleWriter, reportWriter: ReportWriter)
}

object MorphCommand {
  def fromString(cmdName: String): MorphCommand = {
    cmdName match {
      case "merge" => merge
      case _ => throw new IllegalArgumentException(cmdName + " is not a valid command name. Valid command names are merge")
    }
  }

  val undefined: MorphCommand = new MorphCommand {
    def run(config: MorphConfig, processor: SourceCodeFileProcessor, console: ConsoleWriter, reportWriter: ReportWriter) {
      throw new IllegalArgumentException("No command specified on command line")
    }
  }

  val merge: MorphCommand = new MorphCommand {
    def run(config: MorphConfig, processor: SourceCodeFileProcessor, console: ConsoleWriter, reportWriter: ReportWriter) {
      var models: List[CodeModel] = Nil

      config.sources foreach {
        case (name, path) => {
          scanFiles(path, console, p => {
            val originalSource = new SourceCodeFile(p)

            val reader = new SourceCodeReader(originalSource)

            val model = reader.read

            models = models ::: List(model)
          })
        }
      }

      analyse(models, reportWriter)
    }

    def scanFiles(pathOrFilename: String, console: ConsoleWriter, function: (File) => Any) {
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


      //    val html = new ConsoleReportWriter(methodBuckets)
      //
      //    html.generate()


    }

    private def reportDuplicates(methods: Bucket[MethodDeclaration], writer: ReportWriter) {
      writer.methodSummary(methods(0).name, methods.size)
      methods foreach (method => {
        writer.methodDetail(method.source.getFilename)
      })
    }

    private def bucketMethods(models: List[CodeModel]): BucketSet[MethodDeclaration] = {
      val methodBuckets = new BucketSet[MethodDeclaration]
      models foreach (model => {
        model.methods foreach (method => methodBuckets.add(method.syntaxSignature, method))
      })
      methodBuckets
    }


  }
}
