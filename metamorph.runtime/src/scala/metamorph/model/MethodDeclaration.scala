package metamorph.model

import collection.mutable

class MethodDeclaration(_name: String) {
  val name = _name

  var _methodCalls = new mutable.ListMap[String, MethodDeclaration]()

  def methodCalls = _methodCalls

}
