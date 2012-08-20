using System;
using System.IO;

namespace Coder
{
    public class SourceFileReader : IDisposable
    {
        private readonly TextReader _input;

        public SourceFileReader(string filepath):
            this(new StreamReader(filepath))
        {
        }

        public SourceFileReader(TextReader input)
        {
            _input = input;
        }

        public void EachLine(Action<SourceLine> action)
        {
            var lineNumber = 1;
            var line = _input.ReadLine();

            while (line != null)
            {
                action.Invoke(SourceLine.FromString(line, lineNumber));
                line = _input.ReadLine();
                lineNumber++;
            }
        }

        public void Dispose()
        {
            _input.Close();
        }
    }
}