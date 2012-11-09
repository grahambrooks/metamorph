package metamorph


object Program {
  def main(args: Array[String]) {

    val application = new Application(new ConsoleWriter)

    application.run(args)
  }
}
