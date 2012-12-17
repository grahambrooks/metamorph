package metamorph

case class MorphConfig(destination: String = "",
                       sources: Map[String, String] = Map(),
                       command: MorphCommand = MorphCommand.undefined,
                       logging: Logger = Logger.default)