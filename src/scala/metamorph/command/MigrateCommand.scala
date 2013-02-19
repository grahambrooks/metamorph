package metamorph.command

import metamorph._
import metamorph.util.{DirectoryScanner, RootPath, ConsoleWriter}
import metamorph.reporting.ReportWriter
import java.io.File
import metamorph.migration.{ChangeSetBuilder, MigrationReader}
import org.antlr.v4.runtime.ANTLRFileStream
import Java.{SourceCode, SourceCodeFile}
import metamorph.MorphConfig
import parsing.RefactoringParser

class MigrateCommand extends MorphCommand {


  def run(config: MorphConfig, processor: SourceCodeFileProcessor, console: ConsoleWriter, reportWriter: ReportWriter) {
    Logger.trace("Migration")

    applyMigrations(config.scriptFile, config.sources, (refactoringParser: RefactoringParser, sourceCode: SourceCode) => {
      refactoringParser.refactor(sourceCode)
    })
  }


  def scanFiles(pathOrFilename: String, function: (File) => Any) {
    try {
      Logger.trace("Scanning %s", pathOrFilename)
      val root = new File(pathOrFilename)

      val scanner = new DirectoryScanner(root.getCanonicalPath, ".*\\.java")

      scanner eachFile function
    }
    catch {
      case ae: Exception => Logger.error(ae.getMessage)
    }
  }

  def applyMigrations(filePath: String, sources: Map[String, String], function: (RefactoringParser, SourceCode) => Any) {
    if (filePath != null) {
      val file: File = new File(filePath)
      if (file.exists()) {
        val refactoringParser = loadMigrationFile(file)
        sources foreach {
          case (name, rootPath) => {
            val contentSource = new ContentSource(name, new RootPath(rootPath))
            scanFiles(rootPath, filePath => {
              function(refactoringParser, new SourceCodeFile(contentSource, filePath))
            })
          }
        }
      } else {
        Logger.error("Could not locate supplied migration script file %s", file.getAbsolutePath)
      }
    } else {
      Logger.error("Migration file missing. Please supply a migration script file")
    }

  }

  def loadMigrationFile(file: File): RefactoringParser = {
    val reader = new MigrationReader(new ANTLRFileStream(file.getAbsolutePath))

    val migration = reader.read()

    val builder = new ChangeSetBuilder(migration)


    SupportedLanguages.Java.refactoringParser(builder.buildChangeSet.changes)
  }
}
