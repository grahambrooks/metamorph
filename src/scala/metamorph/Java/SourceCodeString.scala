package metamorph.Java

import org.antlr.v4.runtime.ANTLRInputStream
import io.Source
import metamorph.{Signature, AbsolutePath}

class SourceCodeString(text: String) extends SourceCode {
  def antlrStream = new ANTLRInputStream(text)

  def source = Source.fromString(text)

  def absolutePath = AbsolutePath.Invalid

  def name = "STRING"

  def branchPath = {
    throw new UnsupportedOperationException
  }

  def signature = Signature.fromString(text)
}
