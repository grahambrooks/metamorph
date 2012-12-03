package metamorph.model

import scala.collection.JavaConverters._
import org.antlr.v4.runtime.Token
import java.util

trait Import {
  def endLineNumber: Int

  def qualifiedName: String
}

class OriginalImport(importToken: Token, _qualifiedName: util.List[Token]) extends Import {

  def qualifiedName = {
    _qualifiedName.asScala.foldLeft("") {
      (acc, n) => if (acc == "") n.getText else acc + "." + n.getText
    }
  }

  def endLineNumber = {
    _qualifiedName.asScala.last.getLine
  }
}

class NewImport(_qualifiedName: String) extends Import {
  def qualifiedName = _qualifiedName

  def endLineNumber = 0
}
