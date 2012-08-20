using System;

namespace Coder
{
    public class ConsoleWriter
    {
        private static int _tickCount;

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

        public static void Tick()
        {
            var ticks = new[]
                            {
                                '-',
                                '\\',
                                '|',
                                '/',
                            };
            if (_tickCount == 0)
            {
                Console.Write(ticks[0]);
            }
            else
            {
                Console.Write('\b');
                Console.Write(ticks[_tickCount%ticks.Length]);
            }
            _tickCount++;
        }

        public void WriteSeparator(char c)
        {
            for (var i = 0; i < Console.WindowWidth; i++)
            {
                Console.Write(c);
            }
            Console.WriteLine();
        }
    }
}
