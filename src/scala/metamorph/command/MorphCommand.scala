package metamorph.command

import metamorph.{SourceCodeFileProcessor, MorphConfig}
import metamorph.reporting.ReportWriter
import metamorph.util.ConsoleWriter

trait MorphCommand {
  def run(config: MorphConfig, processor: SourceCodeFileProcessor, console: ConsoleWriter, reportWriter: ReportWriter)
}

object MorphCommand {
  def fromString(cmdName: String): MorphCommand = {
    cmdName match {
      case "merge" => merge
      case "analyse" => analyse
      case "analyze" => analyse
      case "migrate" => migrate
      case _ => throw new IllegalArgumentException(cmdName + " is not a valid command name. Valid command names are merge, analyze and migrate")
    }
  }

  val undefined: MorphCommand = new MorphCommand {
    def run(config: MorphConfig, processor: SourceCodeFileProcessor, console: ConsoleWriter, reportWriter: ReportWriter) {
      throw new IllegalArgumentException("No command specified on command line")
    }
  }

  val merge = new MergeCommand()
  val analyse= new AnalyseCommand()
  val migrate = new MigrateCommand()
}
