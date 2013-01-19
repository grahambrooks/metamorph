package metamorph

object SupportedLanguages {
  def Java = new Language {
    def parser = new Parser(){}
  }
}
