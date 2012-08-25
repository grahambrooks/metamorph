package CodeR

import org.antlr.runtime.Token
import java.util.Date
import CodeR.QueryResults

class DefaultQueryResults extends QueryResults {

  var catchStatements: List[CatchToken] = Nil
  var emptyCatchStatements: List[CatchToken] = Nil
  var erroredFiles: List[String] = Nil

  val scannedFiles = collection.mutable.Map[String, List[CatchToken]]()
  var currentFileList: List[CatchToken] = Nil


  def processingFile(filename: String) {
    ConsoleWriter.tick
    currentFileList = List[CatchToken]()
    scannedFiles(filename) = currentFileList
  }

  def errorProcessingFile(filename: String) = erroredFiles = erroredFiles ::: List(filename)

  def catchFound(token: Token) {
    catchStatements = catchStatements ::: List[CatchToken](new CatchToken(token, null, null))
  }

  def emptyCatchFound(catchToken: Token, openingBrace: Token, closingBrace: Token) = {
    emptyCatchStatements = emptyCatchStatements ::: List(new CatchToken(catchToken, openingBrace, closingBrace))
    currentFileList = currentFileList ::: List(new CatchToken(catchToken, openingBrace, closingBrace))
  }

  def printSummaryToConsole() = printSummary(new ConsoleWriter());

  def printSummary(writer: ConsoleWriter) {
    writer.WriteLine();
    writer.WriteLine("Query summary " + new Date)
    writer.WriteSeparator('_')
    writer.WriteLine("Files found                 {0}", scannedFiles.size + erroredFiles.size)
    writer.WriteLine("Successfully scanned        {0}", scannedFiles.size)
    writer.WriteLine("Catch blocks found          {0}", catchStatements.size)
    writer.WriteLine("Empty Catch blocks found    {0}", emptyCatchStatements.size)
    writer.WriteLine()

    scannedFiles.foreach(e => if (e._2.size > 0) writer.WriteLine("{0} empty catch blocks found in {1}", e._2.size, e._1))

    writer.WriteLine()
    writer.WriteLine("Failed to scan:")
    writer.WriteSeparator('_')

    erroredFiles.foreach(errorFile => writer.Error("Error processing file {0}", errorFile))
  }

  def EachFile(function: (String) => Any) = scannedFiles.foreach(pair => function(pair._1))

  def EmptyCatches(filepath: String): List[CatchToken] = scannedFiles(filepath)
}
