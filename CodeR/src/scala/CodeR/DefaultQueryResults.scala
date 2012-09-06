package CodeR

import org.antlr.runtime.Token
import java.util.Date

class DefaultQueryResults extends QueryResults {

  var catchStatements: List[CatchToken] = Nil
  var emptyCatchStatements: List[CatchToken] = Nil
  var failedFiles: List[String] = Nil

  val scannedFiles = collection.mutable.Map[String, List[CatchToken]]()
  var currentFileList: List[CatchToken] = Nil


  def processingFile(filename: String) {
    ConsoleWriter.tick
    currentFileList = List[CatchToken]()
    scannedFiles(filename) = currentFileList
  }

  def errorProcessingFile(filename: String) {
    failedFiles = failedFiles ::: List(filename)
  }

  def catchFound(token: Token) {
    catchStatements = catchStatements ::: List[CatchToken](new CatchToken(token, null, null))
  }

  def emptyCatchFound(catchToken: Token, openingBrace: Token, closingBrace: Token) {
    emptyCatchStatements = emptyCatchStatements ::: List(new CatchToken(catchToken, openingBrace, closingBrace))
    currentFileList = currentFileList ::: List(new CatchToken(catchToken, openingBrace, closingBrace))
  }

  def printSummaryToConsole {
    printSummary(new ConsoleWriter())
  }

  def printSummary(writer: ConsoleWriter) {
    writer.WriteLine()
    writer.WriteLine("Scan summary                %tF", new Date)
    writer.WriteSeparator('_')
    writer.WriteLine("Files found                 %d", scannedFiles.size + failedFiles.size)
    writer.WriteLine("Successfully scanned        %d", scannedFiles.size)
    writer.WriteLine("Catch blocks found          %d", catchStatements.size)
    writer.WriteLine("Empty Catch blocks found    %d", emptyCatchStatements.size)
    writer.WriteLine()

    scannedFiles.foreach(e => if (e._2.size > 0) writer.WriteLine("%d empty catch blocks found in %s", e._2.size, e._1))
    writer.WriteSeparator('_')

    if (failedFiles.size > 0) {
      writer.WriteLine()
      writer.WriteLine("Failed to scan:")
      writer.WriteSeparator('_')

      failedFiles.foreach(errorFile => writer.Error("Error processing file {0}", errorFile))
    }
  }

  def EachFile(function: (String) => Any) {
    scannedFiles.foreach(pair => function(pair._1))
  }

  def EmptyCatches(path: String): List[CatchToken] = scannedFiles(path)
}
