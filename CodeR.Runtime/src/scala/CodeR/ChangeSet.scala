package CodeR

import collection.mutable

class ChangeSet {
  val changes = new mutable.LinkedList[CodeChange]()

  def apply(source: SourceFile): SourceFile = {
    var modified: SourceFile = source
    changes.foreach((change) => modified = change.apply(modified))
    return modified
  }
}
