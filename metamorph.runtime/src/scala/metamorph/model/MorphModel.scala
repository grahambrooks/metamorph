package metamorph.model

import collection.mutable

class MorphModel {
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
