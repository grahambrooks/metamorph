package metamorph.util

import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.Token

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

object Signature {
  val empty: Signature = new Signature {
    val hash = 0
  }

  def fromTree(tree: ParseTree): Signature = {
    var result: Signature = empty

    if (tree != null) {
      if (tree.getPayload != null) {
        if (tree.getPayload.isInstanceOf[Token]) {
          result = composite(result, fromString((tree.getPayload.asInstanceOf[Token]).getText))
        }
      }

      for (i <- 0 until tree.getChildCount) {
        val child: ParseTree = tree.getChild(i)

        result = composite(result, fromTree(child))
      }
    }
    result
  }

  def fromString(s: String): Signature = new Signature {
    val hash = s.hashCode
  }

  def composite(items: Any*): Signature = {
    new Signature {
      val hash = items.foldLeft(0)((a, b) => a + b.hashCode())
    }
  }
}
