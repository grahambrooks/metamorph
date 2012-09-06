package CodeR.CSharp.Parser

import CodeR.CSharp.csParser
import org.antlr.runtime.tree._
import org.antlr.runtime.{ANTLRFileStream, CommonTokenStream}
import CodeR.QueryResults

class CSharpParser {
  def ParseFile(fileName: String, wait: Boolean, results: QueryResults) {
    results.processingFile(fileName)

    val tokens = createLexer(fileName)
    val p = new csParser(tokens)
    p.setTreeAdaptor(new CommonTreeAdaptor())

    val parserResult = p.compilation_unit()

    if (parserResult != null) {
      val tree = parserResult.getTree.asInstanceOf[CommonTree]

      if (tree == null) {
        if (tokens.size > 0) {
          results.errorProcessingFile(fileName)
        }
      }
      else {
        val nodes = new CommonTreeNodeStream(tree)
        nodes.setTokenStream(tokens)
        FindEmptyCatchBlocks(fileName, nodes, results)
      }
    }
  }

  def FindEmptyCatchBlocks(fileName: String, nodes: CommonTreeNodeStream, results: QueryResults) {
    try {
      var current = nodes.nextElement.asInstanceOf[CommonTree]
      while (!nodes.isEOF(current)) {
        if (TokenMatches(current, "catch")) {
          val catchToken = current.getToken
          results.catchFound(catchToken)

          current = nodes.nextElement.asInstanceOf[CommonTree]

          if (TokenMatches(current, "{")) {
            val openingBrace = current.getToken
            current = nodes.nextElement().asInstanceOf[CommonTree]
            if (TokenMatches(current, "}")) {
              results.emptyCatchFound(catchToken, openingBrace, current.getToken)
            }
          }
        }
        current = nodes.nextElement.asInstanceOf[CommonTree]
      }
    }
    catch {
      case e: Exception => results.errorProcessingFile(fileName)
    }
  }

  def TokenMatches(ct: CommonTree, text: String): Boolean = ct != null && ct.getToken != null && ct.getToken.getText == text


  def createLexer(fileName: String): CommonTokenStream = {
    val inputFileName = fileName

    val input = new ANTLRFileStream(inputFileName)

    return new CommonTokenStream(new PreProcessor(input))
  }
}
