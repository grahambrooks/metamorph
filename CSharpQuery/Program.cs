using System;
using System.Diagnostics;
using System.IO;

namespace CSharpQuery
{
    internal class Program
    {
        protected static void PrintStats(object sender, ConsoleCancelEventArgs args)
        {
            Console.WriteLine("Parsed {0} of {1} files. ({2}%)", _count, _filesTotal, _count*100.0/_filesTotal);
        }

        private static int _count;
        private static int _filesTotal;

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

                parser.ParseDirectory(dir, searchPattern, ref _count, ref _filesTotal);
            }
            catch (ApplicationException ae)
            {
                Console.WriteLine(ae.Message);
                Console.ForegroundColor = ConsoleColor.White;
                return;
            }
            finally
            {
                Console.WriteLine("Parsed {0} of {1} files. ({2}%)", _count, _filesTotal, _count*100.0/_filesTotal);
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