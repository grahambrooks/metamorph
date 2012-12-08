package metamorph.Java

import metamorph.Java.JavaParser._
import metamorph.model.{MethodDeclaration, CodeModel}
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.Token
import metamorph.Signature


class CodeReaderVisitor(val model: CodeModel, val source: SourceCode) extends JavaBaseVisitor[Object] {
  override def visitMethodDeclaration(ctx: MethodDeclarationContext) = {

    val sig = new Signature(generateSyntaxSignature(ctx))

    model.add(new MethodDeclaration(source, sig, ctx.Identifier().getSymbol, new TextSpan(ctx.getStart, ctx.getStop)))

    super.visitMethodDeclaration(ctx)
  }

  override def visitPackageDeclaration(ctx: PackageDeclarationContext) = {
    super.visitPackageDeclaration(ctx)
  }

  override def visitClassDeclaration(ctx: ClassDeclarationContext) = {
    println("Class declaration " + ctx.Identifier())

    super.visitClassDeclaration(ctx)
  }

  private def generateSyntaxSignature(tree: ParseTree): String = {

    var result: String = ""

    if (tree.getPayload.isInstanceOf[Token]) {
      result += (tree.getPayload.asInstanceOf[Token]).getText
    }

    for (i <- 0 until tree.getChildCount) {
      val child: ParseTree = tree.getChild(i)

      result += generateSyntaxSignature(child)
    }
    result
  }
}

