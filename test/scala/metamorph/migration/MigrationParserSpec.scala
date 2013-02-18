package metamorph.migration

import org.scalatest.FunSpec
import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream}

class MigrationParserSpec extends FunSpec {
  describe("Migration Parser") {
    it("recognises rename") {
      val migrationText = "migration rename com.some.class to other;"

      val parser = new MigrationParser(new CommonTokenStream(new MigrationLexer(new ANTLRInputStream(migrationText))))
      parser.migrationFile()
    }
  }
}