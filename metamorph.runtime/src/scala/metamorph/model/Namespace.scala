package metamorph.model

import collection.mutable


class Namespace(_name: String) {
  val name = _name
  var _classes = new mutable.ListMap[String, ClassDeclaration]()
  var _currentClass: ClassDeclaration = _

  def classes = _classes

  def setCurrentClass(clazz: ClassDeclaration) {
    _classes.put(clazz.name, clazz)
    _currentClass = clazz
  }


}
