package metamorph.model

trait LanguageElement {
}


class ClassSpecification(name: String) extends LanguageElement {
  def getName:String = name
}
