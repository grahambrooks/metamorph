package metamorph

import collection.mutable

class BucketSet[T] {

  val buckets = new mutable.HashMap[Signature, Bucket[T]]

  def add(signature: Signature, item: T) {
    if (buckets.contains(signature)) {
      buckets(signature).add(item)
    } else {
      buckets(signature) = new Bucket(item)
    }
  }

  def duplicates(): List[Bucket[T]] = buckets.values.filter(bucket => bucket.hasDuplicates).toList

  def getDuplicateCount = duplicates().size

  def getDuplicates = duplicates()

  def eachDuplicate(function: (Bucket[T]) => Any) {
    buckets.values foreach (bucket => {
      if (bucket.hasDuplicates) {
        function(bucket)
      }
    })
  }

  private def hasDuplicates(items: List[T]): Boolean = {
    items.size > 1
  }
}
