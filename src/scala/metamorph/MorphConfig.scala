package metamorph

import command.MorphCommand

case class MorphConfig(destination: String = "",
                       sources: Map[String, String] = Map(),
                       outputPath: String = "metamorph-analysis",
                       command: MorphCommand = MorphCommand.undefined,
                       logging: Logger = Logger.default)
