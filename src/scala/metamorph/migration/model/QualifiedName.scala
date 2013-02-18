package metamorph.migration.model

class QualifiedName(val qualification: List[String], val name: String) {
  def this(name: String) = this(List(), name)

  override def toString = {
    if (qualification.length > 0) {
      val qualificationString = qualification.foldLeft("") {
        (s, e) => if (s == "") e else s + "." + e
      }

      qualificationString + "." + name
    } else {
      name
    }
  }

  override def equals(obj: Any) = {
    obj match {
      case other: QualifiedName => other.qualification == qualification && other.name == name
      case _ => false
    }
  }
}
