package metamorph.migration

import org.scalatest.FunSpec
import org.antlr.v4.runtime.ANTLRInputStream

class MigrationReaderSpec extends FunSpec {
  describe("Migration Reader") {
    it("reads migration(s)") {
      val migrationText = "migration rename com.some.class.current to other;"

      val reader = new MigrationReader(new ANTLRInputStream(migrationText))

      val migration = reader.read()

      assert(migration.count === 1)
      assert(migration(0).kind == "Rename")
      assert(migration(0).asInstanceOf[RenameMigration].predicate.toString == "com.some.class.current")
      assert(migration(0).asInstanceOf[RenameMigration].newName.toString == "other")
    }
  }
}
