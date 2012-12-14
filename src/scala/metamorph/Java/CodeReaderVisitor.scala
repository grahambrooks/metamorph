package metamorph.Java

import metamorph.Java.JavaParser._
import metamorph.model._
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.Token
import metamorph.Signature


class CodeReaderVisitor(val model: CodeModel, val source: SourceCode) extends JavaBaseVisitor[Object] {

  override def visitCompilationUnit(ctx: CompilationUnitContext) = {
    model.modelSignature = new Signature(generateSyntaxSignature(ctx))
    super.visitCompilationUnit(ctx)
  }

  override def visitMethodDeclaration(ctx: MethodDeclarationContext) = {

    val sig = new Signature(generateSyntaxSignature(ctx))

    model.add(new MethodDeclaration(source, sig, ctx.Identifier().getSymbol, new TextSpan(ctx.getStart, ctx.getStop)))

    super.visitMethodDeclaration(ctx)
  }

  override def visitPackageDeclaration(ctx: PackageDeclarationContext) = {
    //    model.add(new ImportDeclaration(ctx.p,buildPackageDeclaration(ctx.qualifiedName())))
    super.visitPackageDeclaration(ctx)
  }

  override def visitClassDeclaration(ctx: ClassDeclarationContext) = {
    super.visitClassDeclaration(ctx)
  }

  //  private def buildPackageDeclaration(ctx: QualifiedNameContext) : QualifiedName = {
  //
  //    ctx.a
  //    ctx.getChildCount
  //    ctx.qualifiedName()
  //  }

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
