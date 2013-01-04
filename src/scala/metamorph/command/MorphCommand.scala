package metamorph.command

import metamorph.{ReportWriter, ConsoleWriter, SourceCodeFileProcessor, MorphConfig}

trait MorphCommand {
  def run(config: MorphConfig, processor: SourceCodeFileProcessor, console: ConsoleWriter, reportWriter: ReportWriter)
}

object MorphCommand {
  def fromString(cmdName: String): MorphCommand = {
    cmdName match {
      case "merge" => merge
      case "analyse" => analyse
      case "analyze" => analyse
      case _ => throw new IllegalArgumentException(cmdName + " is not a valid command name. Valid command names are merge")
    }
  }

  val undefined: MorphCommand = new MorphCommand {
    def run(config: MorphConfig, processor: SourceCodeFileProcessor, console: ConsoleWriter, reportWriter: ReportWriter) {
      throw new IllegalArgumentException("No command specified on command line")
    }
  }

  val merge: MorphCommand = new MergeCommand()
  val analyse: MorphCommand = new AnalyseCommand()
}
