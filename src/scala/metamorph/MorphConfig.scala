package metamorph

import command.MorphCommand

case class MorphConfig(destination: String = "",
                       sources: Map[String, String] = Map(),
                       outputPath: String = "analysis.html",
                       command: MorphCommand = MorphCommand.undefined,
                       logging: Logger = Logger.default)
