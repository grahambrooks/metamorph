using Antlr.Runtime;

namespace Coder
{
    internal class SourceStatement : ISourceLocation
    {
        private readonly int _charPositionInLine;
        private readonly int _line;
        private readonly string _text;

        private SourceStatement(int line, int charPositionInLine, string text)
        {
            _line = line;
            _charPositionInLine = charPositionInLine;
            _text = text;
        }

        #region ISourceLocation Members

        public int Line
        {
            get { return _line; }
        }

        public int StartCharacterOffset
        {
            get { return _charPositionInLine; }
        }

        public int EndCharacterOffset
        {
            get { return _charPositionInLine + _text.Length; }
        }

        #endregion

        public static SourceStatement FromToken(IToken t)
        {
            return new SourceStatement(t.Line, t.CharPositionInLine, t.Text);
        }
    }
}