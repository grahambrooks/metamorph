package metamorph.model

import org.antlr.v4.runtime.Token
import metamorph.Java.{SourceCode, TextSpan}
import metamorph.{StringSignature, Signature}

class MethodDeclaration(val source: SourceCode, val syntaxSignature: Signature, nameToken: Token, val span: TextSpan) {

  def name: String = nameToken.getText
  def getName = name

  def signature: Signature = {
    val textSource = source.getSource

    val i = textSource.getLines()
    var methodText = ""
    var lineNumber = 1

    while (lineNumber < span.start.getLine) {
      i.next()
      lineNumber += 1
    }

    if (span.start.getLine == span.stop.getLine) {
      methodText += i.next().substring(span.start.getCharPositionInLine, span.stop.getCharPositionInLine)
    } else {
      methodText += i.next().substring(span.start.getCharPositionInLine)
      methodText += "\n"
      lineNumber += 1

      while (lineNumber < span.stop.getLine) {
        methodText += i.next() + "\n"
        lineNumber += 1
      }

      methodText += i.next().substring(0, span.stop.getCharPositionInLine + span.stop.getText.length)
    }

    StringSignature(nameToken.getText)
  }
}
