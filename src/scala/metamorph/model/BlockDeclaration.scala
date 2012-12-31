package metamorph.model

import metamorph.Signature
import metamorph.Java.{SourceCode, TextSpan}

class BlockDeclaration(val source: SourceCode, val signature: Signature, val span: TextSpan) {
  def lineCount: Int = span.lineCount

}
