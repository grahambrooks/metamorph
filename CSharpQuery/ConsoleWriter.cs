using System;

namespace CSharpQuery
{
    public class ConsoleWriter
    {
        public void WriteLine()
        {
            Console.WriteLine();
        }

        public void WriteLine(string s, params object[] p)
        {
            Console.WriteLine(s, p);
        }

        public void Warning(string s, params object[] p)
        {
            Console.ForegroundColor = ConsoleColor.Yellow;
            Console.WriteLine(s, p);
            Console.ForegroundColor = ConsoleColor.White;
        }

        public void Error(string s, params object[] p)
        {
            Console.ForegroundColor = ConsoleColor.Red;
            Console.WriteLine(s, p);
            Console.ForegroundColor = ConsoleColor.White;
        }
    }
}