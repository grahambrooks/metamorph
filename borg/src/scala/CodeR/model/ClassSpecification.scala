package CodeR.model

trait LanguageElement {
}


class ClassSpecification(name: String) extends LanguageElement {
  def getName:String = { return name }
}
