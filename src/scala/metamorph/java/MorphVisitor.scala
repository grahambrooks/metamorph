package metamorph.java

import metamorph.model.{MethodDeclaration, ClassDeclaration, Namespace, MorphModel}
import metamorph.java.JavaParser._

class MorphVisitor extends JavaBaseVisitor[Any] {
  var _model: MorphModel = new MorphModel

  def model: MorphModel = {
    return _model
  }

  override def visitMethodDeclaration(ctx: MethodDeclarationContext) = {
    _model.setCurrentMethod(new MethodDeclaration(ctx.Identifier().getText))
    super.visitMethodDeclaration(ctx)
  }

  override def visitGenericMethodDeclaration(ctx: GenericMethodDeclarationContext) = super.visitGenericMethodDeclaration(ctx)

  override def visitPackageDeclaration(ctx: PackageDeclarationContext) = {

    _model.setCurrentNamespace(new Namespace(ctx.qualifiedName.getText))

    super.visitPackageDeclaration(ctx)
  }

  override def visitClassDeclaration(ctx: ClassDeclarationContext) = {

    _model.setCurrentClass(new ClassDeclaration(ctx.Identifier.getText))
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
