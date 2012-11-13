package metamorph.model

import collection.mutable


class Namespace(_name: String) {
  val name = _name
  var classes = new mutable.ListMap[String, ClassDeclaration]()
  var currentClass: ClassDeclaration = _

  def setCurrentClass(clazz: ClassDeclaration) {
    classes.put(clazz.name, clazz)
    currentClass = clazz
  }


}
