package metamorph.java

import metamorph.model.{Namespace, MorphModel}
import metamorph.java.JavaParser.PackageDeclarationContext

class MorphVisitor extends JavaBaseVisitor[Any] {
  var _model: MorphModel = new MorphModel

  def model: MorphModel = {
    return _model
  }

  override def visitPackageDeclaration(ctx: PackageDeclarationContext) = {

    _model.setCurrentNamespace(new Namespace(ctx.qualifiedName.getText))

    super.visitPackageDeclaration(ctx)
  }
}
