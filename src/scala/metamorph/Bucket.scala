package metamorph

import collection.mutable

class Bucket[T] {
  val bucket = new mutable.HashMap[Signature, List[T]]

  def add(signature: Signature, item: T) {
    if (bucket.contains(signature)) {
      bucket(signature) :::= List(item)
    } else {
      bucket(signature) = List(item)
    }
  }

  def eachDuplicate(function: (List[T]) => Any) {
    bucket.values foreach (items => {
      if (hasDuplicates(items)) {
        function(items)
      }
    })
  }

  private def hasDuplicates(items: List[T]): Boolean = {
    items.size > 1
  }
}
