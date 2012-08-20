namespace Coder
{
    public class SourceLine
    {
        private readonly string _text;
        private readonly int _lineNumber;

        private SourceLine(string text, int lineNumber)
        {
            _text = text;
            _lineNumber = lineNumber;
        }

        public int LineNumber
        {
            get {
                return _lineNumber;
            }
        }

        public string Text
        {
            get {
                return _text;
            }
        }

        public static SourceLine FromString(string text, int lineNumber)
        {
            return new SourceLine(text, lineNumber);
        }
    }
}