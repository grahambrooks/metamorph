package metamorph.model

import metamorph.Java.{SourceCode, TextSpan}
import metamorph.util.Signature

class BlockDeclaration(val codeModel: CodeModel, val source: SourceCode, val signature: Signature, val span: TextSpan) {
  def lineCount: Int = span.lineCount

}
