package metamorph.model

import collection.mutable

class ClassDeclaration(_name: String) {
  val name: String = _name
  var _methods = new mutable.ListMap[String, MethodDeclaration]()
  var _currentMethod: MethodDeclaration = _

  def methods = _methods

  def setCurrentMethod(method: MethodDeclaration) {
    _methods.put(method.name, method)
    _currentMethod = method
  }

}
