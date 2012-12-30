package metamorph.Java

import metamorph.Java.JavaParser._
import metamorph.model._
import metamorph.Signature


class CodeReaderVisitor(val model: CodeModel, val source: SourceCode) extends JavaBaseVisitor[Object] {

  override def visitCompilationUnit(ctx: CompilationUnitContext) = {
    model.modelSignature = Signature.fromTree(ctx)
    super.visitCompilationUnit(ctx)
  }

  override def visitMethodDeclaration(ctx: MethodDeclarationContext) = {

    model.add(
      new MethodDeclaration(source,
        Signature.fromTree(ctx),
        ctx.Identifier().getSymbol,
        new TextSpan(ctx.getStart, ctx.getStop)))

    super.visitMethodDeclaration(ctx)
  }

  override def visitClassDeclaration(ctx: ClassDeclarationContext) = {
    model.typeSignature = Signature.composite(ctx.Identifier.getText,
      Signature.fromTree(ctx.typeParameters),
      Signature.fromTree(ctx.typeList),
      Signature.fromTree(ctx.`type`))

    model.typeDeclaration = new TypeDeclaration(ctx.Identifier().getText)

    super.visitClassDeclaration(ctx)
  }

  override def visitPackageDeclaration(ctx: PackageDeclarationContext) = {
    //    model.add(new ImportDeclaration(ctx.p,buildPackageDeclaration(ctx.qualifiedName())))
    super.visitPackageDeclaration(ctx)
  }
}

