package metamorph

import Java._
import model.{MethodDeclaration, CodeModel}
import java.io.File

object Tool {
  def main(args: Array[String]) {
    val tool = new Tool(new DefaultJavaFileProcessor(), new ConsoleWriter, new ConsoleReportWriter)

    tool.run(args)
  }
}

class Tool(processor: SourceCodeFileProcessor, val console: ConsoleWriter, val reportWriter: ReportWriter) {

  val parser = new scopt.immutable.OptionParser[MorphConfig]("metamorph", "0.1") {
    def options = Seq(
      arg("command", "merge/refactor") {
        (cmd: String, c: MorphConfig) => c.copy(command = MorphCommand.fromString(cmd))
      },
      flag("v", "verbose", "Output useful execution information. Valuable in identifying processing problems") {
        (c: MorphConfig) => c.copy(logging = Logger.verbose)
      },
      opt("d", "destination", "Where to put the command output") {
        (v: String, c: MorphConfig) => c.copy(destination = v)
      },
      keyValueOpt("s", "source", "<source-name>", "<source-path>", "Define a source for merge or refactoring commands") {
        (key: String, value: String, c: MorphConfig) => c.copy(sources = (Map[String, String](key -> value) ++ c.sources))
      }
    )
  }

  def run(args: Array[String]) {
    parser.parse(args, MorphConfig()) map {
      config => {
        println("Valid command line parameters")

        config.command.run(config,processor, console, reportWriter)

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
    } getOrElse {
      println("Invalid parameters")
    }
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
