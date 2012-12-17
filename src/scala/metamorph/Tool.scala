package metamorph

import Java._

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
        (key: String, value: String, c: MorphConfig) => c.copy(sources = (c.sources ++ Map(key -> value)))
      }
    )
  }

  def run(args: Array[String]) {
    parser.parse(args, MorphConfig()) map {
      config => {
        Logger.current = config.logging
        config.command.run(config, processor, console, reportWriter)
      }
    } getOrElse {
      println("Invalid parameters")
    }
  }
}
