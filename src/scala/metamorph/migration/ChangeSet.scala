package metamorph.migration

import metamorph.refactor.CodeChange

case class ChangeSet(changes: List[CodeChange] = List()) {
  def count = changes.length

  def apply(index: Int): CodeChange = changes(index)
}
