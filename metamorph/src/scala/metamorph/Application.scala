package metamorph

import CSharp.Parser.CSharpParser
import java.io.File

class Application(console: ConsoleWriter) {
  val Results = new DefaultQueryResults()

  def run(args: Array[String]) {
    console.WriteLine("metamorph - source CODE Rewriter")
    //    if (args.length == 0) {
    //      Console.err.println("Usage: coder <source-path>")
    //      return
    //    }


    //    try {
    val root = new File("Tests")
    val scanner = new DirectoryScanner(root.getCanonicalPath, ".*\\.cs")

    val parser = new CSharpParser()

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

    scanner.eachFile(path => parser.ParseFile(path.getCanonicalPath, wait = true, results = Results))

    Results.printSummaryToConsole

    ApplyEdits(Results)
    //    }
    //    catch  {
    //      case ae: Exception => Console.println(ae.getMessage)
    //    }
  }

  def ApplyEdits(results: DefaultQueryResults) {
    results.EachFile(AddLogging)
  }

  def AddLogging(path: String) {
    //    var emptyCatches = Results.EmptyCatches(path);
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
    //    string editedPath = path + ".edited";
    //    using( var source = new SourceFileReader(path))
    //    {
    //      using( var destinaton = new SourceFileWriter(editedPath))
    //      {
    //        var reWriter = new SourceCodeReWriter(source, destinaton);
    //        reWriter.ReWrite(edits);
    //      }
    //    }
    //
    //    File.Copy(editedPath, path, true);
    //    File.Delete(editedPath);
  }


}
