package metamorph.model

import collection.mutable

class MorphModel {
  val globalNamespace = new Namespace("##GLOBAL##")
  var currentNamespace: Namespace = globalNamespace
  var _namespaces = new mutable.ListMap[String, Namespace]()

  def setCurrentClass(classDeclaration: ClassDeclaration) {
    currentNamespace.setCurrentClass(classDeclaration)
  }

  def setCurrentMethod(method: MethodDeclaration) {
    currentNamespace.currentClass.setCurrentMethod(method)
  }

  def setCurrentNamespace(namespace: Namespace) {
    _namespaces.put(namespace.name, namespace)
    currentNamespace = namespace
  }

  def namespaces: mutable.Map[String, Namespace] = {
    return _namespaces
  }

}
