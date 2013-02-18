package metamorph.migration

import model.QualifiedName

class Predicate(name: QualifiedName) {
  override def toString = name.toString
}
