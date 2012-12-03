package metamorph.Java
import scala.collection.JavaConverters._
import metamorph.model.{QualifiedName, PackageDeclaration, OriginalImport, CodeModel}
import org.antlr.v4.runtime.{Token, CommonTokenStream}
import java.util

class SourceCodeReader(code: SourceCode) extends JavaParserActions {
  val model = new CodeModel

  def read: CodeModel = {
    val parser = new JavaParser(new CommonTokenStream(new JavaLexer(code.getInputStream)))
    parser.parserActions = this
    val tree = parser.compilationUnit

    //    PrintingListener.toStringTree(tree, parser)
    //
    //    new CodeModel
    model
  }

  def importDeclaration(importToken: Token, qualifiedName: util.List[Token]) {
    model.add(new OriginalImport(importToken, qualifiedName))
  }

  def packageDeclaration(packageToken: Token, nameTokens: util.List[Token]) {
    model.packageDeclaration = new PackageDeclaration(packageToken, new QualifiedName(nameTokens.asScala.toList))
  }
}
