package metamorph.migration

import model.QualifiedName
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import metamorph.migration.MigrationParser.{MigrationDeclarationContext, RenameMigrationContext, MigrationFileContext}
import org.antlr.v4.runtime.tree.TerminalNode
import scala.collection.JavaConverters._

class MigrationReader(input: ANTLRInputStream) {

  class MigrationReaderVisitor() extends MigrationBaseVisitor[Migration] {

    override def visitRenameMigration(ctx: RenameMigrationContext) = {
      super.visitRenameMigration(ctx)

      new RenameMigration(new Predicate(buildQualifiedName(ctx.predicate.Identifier.asScala.toArray)), ctx.newName.getText)
    }

    private def buildQualifiedName(elements: Array[TerminalNode]): QualifiedName = {
      val name = elements.last.getSymbol.getText

      val qualification = elements.take(elements.length - 1).foldLeft(List[String]()) {
        (list, item) => list ::: List(item.getSymbol.getText)
      }
      new QualifiedName(qualification, name)
    }

    override def visitMigrationFile(ctx: MigrationFileContext) = {
      super.visitMigrationFile(ctx)

      new Migration {
        val migrations = ctx.migrationDeclaration().asScala.toList.foldLeft(List[Migration]()) {
          (migrations, declaration) => migrations.::(visitMigrationDeclaration(declaration))
        }

        def kind = "Rename"

        def apply(index: Int) = migrations(index)

        def count = migrations.length
      }
    }

    override def visitMigrationDeclaration(ctx: MigrationDeclarationContext) = {
      visitRenameMigration(ctx.renameMigration())
    }
  }

  def read(): Migration = {
    val parser = new MigrationParser(new CommonTokenStream(new MigrationLexer(input)))
    val contents = parser.migrationFile()

    val visitor = new MigrationReaderVisitor
    visitor.visit(contents)
  }
}
