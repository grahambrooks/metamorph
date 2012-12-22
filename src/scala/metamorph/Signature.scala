package metamorph

abstract class Signature {
  val hash: Int

  override def hashCode(): Int = hash

  override def equals(obj: Any) = {
    if (obj.isInstanceOf[Signature]) {
      hash == (obj.asInstanceOf[Signature].hash)
    } else {
      false
    }
  }
}

object EmptySignature extends Signature{
  val hash = 0
}

case class StringSignature(s: String) extends Signature {
  val hash = s.hashCode
}

case class CompositeSignature(items: Any*) extends Signature {
  val hash = items.foldLeft(0)((a, b) => a + b.hashCode())
}
