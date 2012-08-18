using System;
using System.Diagnostics;
using System.IO;
using NLog;

namespace CSharpQuery
{
    internal class Program
    {
        private static readonly Logger Logger = LogManager.GetCurrentClassLogger();
        static readonly DefaultQueryResults results = new DefaultQueryResults();

        protected static void PrintStats(object sender, ConsoleCancelEventArgs args)
        {
            results.PrintSummaryToConsole();
        }

        private static void Main(string[] args)
        {
            var parser = new Parse();
            // Check usage.
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
                var searchPattern = Path.GetFileName(args[0]);

                var dir = Path.GetDirectoryName(args[0]);
                if (String.IsNullOrEmpty(dir))
                    dir = Environment.CurrentDirectory;

                parser.ParseDirectory(dir, searchPattern, results);

                results.PrintSummaryToConsole();

//                var statement = MethodCall("Logger.Log", new Parameters[]
//                {
//                    "Auto-inserted logging statement for empty catch block",
//                    CatchClause.Identifier.Name;
//                })                ;
//
//
//
//                CodeEdit.Insert(CatchClause("Exception", "e"), After(Catch.WithNot(CatchClause));
//
//                CodeEdit.Insert(statement, Empty(CatchBlock).After(OpeningBrace));

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
    }
}