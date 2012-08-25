package CodeR

import CSharp.Parser.CSharpParser
import scala.Console
import java.io.File

class Application {
  val Results = new DefaultQueryResults()

  def run(args: Array[String]) {
    println("CodeR - source CODE Rewriter")
//    if (args.length == 0) {
//      Console.err.println("Usage: coder <source-path>")
//      return
//    }




//    try {
    val root = new File("Tests")
      val scanner = new DirectoryScanner(root.getCanonicalPath, ".*\\.cs")

      var parser = new CSharpParser()

//      val file = new File(args(0))
//      val searchPattern = file.getCanonicalFile
//
//
//      var dir = file.getCanonicalPath
//
//      if (dir.isEmpty)
//        dir = System.getProperty("user.dir")
//
//      val scanner = new DirectoryScanner(dir, ".*\\.cs")

      scanner.eachFile(filepath => parser.ParseFile(filepath.getCanonicalPath, true, Results))

      Results.printSummaryToConsole

      ApplyEdits(Results)
//    }
//    catch  {
//      case ae: Exception => Console.println(ae.getMessage)
//    }
  }

  def ApplyEdits(results : DefaultQueryResults) {
    results.EachFile(AddLogging)
  }

  def AddLogging(filepath : String) {
//    var emptyCatches = Results.EmptyCatches(filepath);
//
//    var edits = new CSharpCodeEdits();
//
//    foreach(CatchToken emptyCatch in emptyCatches) {
//      edits.Add(emptyCatch.Line, SourceEdit.Insert("(Exception exp)").After(emptyCatch.CatchStatement));
//      edits.Add(emptyCatch.OpeningBrace.Line,
//        SourceEdit.Insert("Logger.ErrorException(\"Auto inserted log\", exp);").OnAnNewIndentedLine().
//          After(emptyCatch.OpeningBrace));
//    }
//
//    string editedPath = filepath + ".edited";
//    using( var source = new SourceFileReader(filepath))
//    {
//      using( var destinaton = new SourceFileWriter(editedPath))
//      {
//        var reWriter = new SourceCodeReWriter(source, destinaton);
//        reWriter.ReWrite(edits);
//      }
//    }
//
//    File.Copy(editedPath, filepath, true);
//    File.Delete(editedPath);
  }


}
