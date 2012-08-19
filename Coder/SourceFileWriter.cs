using System;
using System.IO;
using System.Text;
using Coder;

namespace CSharpQuery
{
    public class SourceFileWriter : IDisposable
    {
        private readonly TextWriter _writer;

        public SourceFileWriter(TextWriter writer)
        {
            _writer = writer;
        }

        public SourceFileWriter(string filepath) : this(new StreamWriter(filepath))
        {
        }

        public void Write(string text)
        {
            _writer.Write(text);
        }

        public void WriteLine(string text)
        {
            _writer.WriteLine(text);
        }

        public void ReWrite(string text, SourceEdit edit)
        {
            var replacement = new StringBuilder();
            var ctx = new EditContext(text);
            edit.Apply(ctx, replacement);
            WriteLine(replacement.ToString());
        }

        public void Dispose()
        {
            _writer.Close();
        }
    }
}