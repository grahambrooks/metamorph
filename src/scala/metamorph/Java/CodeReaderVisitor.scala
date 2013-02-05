package metamorph.Java

import metamorph.Java.JavaParser._
import metamorph.model._
import metamorph.analysis.CodeStatistics
import metamorph.util.Signature


class CodeReaderVisitor(val model: CodeModel, val source: SourceCode) extends JavaBaseVisitor[Object] {

  override def visitBlock(ctx: BlockContext) = {
    model.add(
      new BlockDeclaration(
        model,
        source,
        Signature.fromTree(ctx), new TextSpan(ctx.start, ctx.end)
      ))

    super.visitBlock(ctx)
  }

  override def visitCompilationUnit(ctx: CompilationUnitContext) = {
    model.modelSignature = Signature.fromTree(ctx)
    model.stats = CodeStatistics.fromTree(ctx)
    super.visitCompilationUnit(ctx)
  }

  override def visitMethodDeclaration(ctx: MethodDeclarationContext) = {

    model.add(new MethodDeclaration(model, source,
      Signature.fromTree(ctx),
      CodeStatistics.fromTree(ctx),
      ctx.Identifier().getSymbol,
      new TextSpan(ctx.getStart, ctx.getStop))
    )

    super.visitMethodDeclaration(ctx)
  }

  override def visitClassDeclaration(ctx: ClassDeclarationContext) = {
    model.typeSignature = Signature.composite(ctx.Identifier.getText,
      Signature.fromTree(ctx.typeParameters),
      Signature.fromTree(ctx.typeList),
      Signature.fromTree(ctx.`type`),
      model.typeSignature)

    model.typeDeclarations = model.typeDeclarations ::: List(new TypeDeclaration(ctx.Identifier().getText))

    super.visitClassDeclaration(ctx)
  }

  override def visitPackageDeclaration(ctx: PackageDeclarationContext) = {
    //    model.add(new ImportDeclaration(ctx.p,buildPackageDeclaration(ctx.qualifiedName())))
    super.visitPackageDeclaration(ctx)
  }
}

