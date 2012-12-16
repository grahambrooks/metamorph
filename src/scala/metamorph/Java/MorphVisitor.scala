package metamorph.Java

import metamorph.Java.JavaParser._

class MorphVisitor extends JavaBaseVisitor[Any] {

  override def visitMethodDeclaration(ctx: MethodDeclarationContext) = {

    super.visitMethodDeclaration(ctx)
  }

  override def visitGenericMethodDeclaration(ctx: GenericMethodDeclarationContext) = super.visitGenericMethodDeclaration(ctx)

  override def visitPackageDeclaration(ctx: PackageDeclarationContext) = {


    super.visitPackageDeclaration(ctx)
  }

  override def visitClassDeclaration(ctx: ClassDeclarationContext) = {

    super.visitClassDeclaration(ctx)
  }

  override def visitArguments(ctx: ArgumentsContext) = {

    println("Arguments")
    for (childIndex <- 0 to ctx.getChildCount) {
      println(ctx.getChild(childIndex).getText)
    }

    super.visitArguments(ctx)
  }

  override def visitExpression(ctx: ExpressionContext) = {
    println("Expression " + ctx.toStringTree)
    val invocation = ctx.explicitGenericInvocation

    if (invocation != null) {
      println(invocation.Identifier().getText)
    } else {
      if (ctx.Identifier() != null) {
        println(ctx.Identifier().getText)
      }
    }

    super.visitExpression(ctx)
  }
}
