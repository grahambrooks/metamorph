package metamorph.model

import collection.mutable

class MorphModel {
  def setCurrentClass(classdecl: ClassDeclaration) {
    currentNamespace.setCurrentClass(classdecl)
  }

  var currentNamespace: Namespace = new Namespace("GLOBAL")
  var _namespaces = new mutable.ListMap[String, Namespace]()

  def setCurrentNamespace(namespace: Namespace) {
    _namespaces.put(namespace.name, namespace)
    currentNamespace = namespace
  }

  def namespaces: mutable.Map[String, Namespace] = {
    return _namespaces
  }

}
