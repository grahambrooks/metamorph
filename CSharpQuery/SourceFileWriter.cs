using System.IO;
using System.Text;

namespace CSharpQuery
{
    public class SourceFileWriter
    {
        private readonly TextWriter _writer;

        public SourceFileWriter(TextWriter writer)
        {
            _writer = writer;
        }

        public void Write(string text)
        {
            _writer.Write(text);
        }

        public void ReWrite(string text, SourceEdit edit)
        {
            var replacement = new StringBuilder();
            edit.Apply(text, replacement);
            Write(replacement.ToString());
        }
    }
}