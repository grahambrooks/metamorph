package metamorph

class Signature(val o: Any) {
  override def hashCode(): Int = {
    o.hashCode()
  }

  override def equals(obj: Any) = {
    if (obj.isInstanceOf[Signature]) {
      o.equals(obj.asInstanceOf[Signature].o)
    } else {
      false
    }
  }
}
