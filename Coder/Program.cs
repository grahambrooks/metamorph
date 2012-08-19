using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using CSharpQuery;

namespace Coder
{
    internal class Program
    {
        private static readonly DefaultQueryResults Results = new DefaultQueryResults();

        protected static void PrintStats(object sender, ConsoleCancelEventArgs args)
        {
            Results.PrintSummaryToConsole();
        }

        private static void Main(string[] args)
        {
            var parser = new Parse();

            if (args.Length == 0)
            {
                Console.Error.WriteLine("Usage: cparse <input-file> -q -n -a -D MACRO");
                Console.Error.WriteLine("-q go Quick, don't wait if errors");
                Console.Error.WriteLine("-n print Nodes");
                Console.Error.WriteLine("-a skip files with Archive attribute set");
                return;
            }

            Console.CancelKeyPress += PrintStats;

            try
            {
                string searchPattern = Path.GetFileName(args[0]);

                string dir = Path.GetDirectoryName(args[0]);
                if (String.IsNullOrEmpty(dir))
                    dir = Environment.CurrentDirectory;

                parser.ParseDirectory(dir, searchPattern, Results);

                Results.PrintSummaryToConsole();

                ApplyEdits(Results);
            }
            catch (ApplicationException ae)
            {
                Console.WriteLine(ae.Message);
                Console.ForegroundColor = ConsoleColor.White;
                return;
            }

            // Pause if debugging so the console doesn't disappear.
            if (Debugger.IsAttached)
            {
                Console.WriteLine("Done...press the any key :)");
                Console.ReadKey();
            }
        }

        private static void ApplyEdits(DefaultQueryResults results)
        {
            results.EachFile(AddLogging);
        }

        private static void AddLogging(string filepath)
        {
            List<CatchToken> emptyCatches = Results.EmptyCatches(filepath);

            var edits = new CSharpCodeEdits();

            foreach (CatchToken emptyCatch in emptyCatches)
            {
                edits.Add(emptyCatch.Line, SourceEdit.Insert("(Exception exp)").After(emptyCatch.CatchStatement));
                edits.Add(emptyCatch.OpeningBrace.Line,
                          SourceEdit.Insert("Logger.ErrorException(\"Auto inserted log\", exp);").OnAnNewIndentedLine().
                              After(emptyCatch.OpeningBrace));
            }

            string editedPath = filepath + ".edited";
            using (var source = new SourceFileReader(filepath))
            {
                using (var destinaton = new SourceFileWriter(editedPath))
                {
                    var reWriter = new SourceCodeReWriter(source, destinaton);
                    reWriter.ReWrite(edits);
                }
            }

            File.Copy(editedPath, filepath, true);
            File.Delete(editedPath);
        }
    }
}