package metamorph.Java

import metamorph.Java.JavaParser._
import metamorph.model.{MethodDeclaration, CodeModel}

class CodeReaderVisitor(val model: CodeModel) extends JavaBaseVisitor[Object] {
  override def visitMethodDeclaration(ctx: MethodDeclarationContext) = {
    model.add(new MethodDeclaration(ctx.Identifier().getSymbol))
    super.visitMethodDeclaration(ctx)
  }
}

