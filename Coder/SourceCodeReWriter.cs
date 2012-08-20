namespace Coder
{
    internal class SourceCodeReWriter
    {
        private readonly SourceFileReader _input;
        private readonly SourceFileWriter _output;

        public SourceCodeReWriter(SourceFileReader input, SourceFileWriter output)
        {
            _input = input;
            _output = output;
        }

        public void ReWrite(ICodeEdits edits)
        {
            _input.EachLine(line => edits.Apply(line, _output));
        }
    }
}