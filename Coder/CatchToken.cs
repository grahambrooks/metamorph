using Antlr.Runtime;

namespace Coder
{
    internal class CatchToken
    {
        private readonly ISourceLocation _catchStatement;
        private readonly ISourceLocation _closingBrace;
        private readonly ISourceLocation _openingBrace;

        public CatchToken(IToken ct)
        {
            _catchStatement = SourceStatement.FromToken(ct);
        }

        public CatchToken(IToken ct, IToken ob, IToken cb)
        {
            _catchStatement = SourceStatement.FromToken(ct);
            _openingBrace = SourceStatement.FromToken(ob);
            _closingBrace = SourceStatement.FromToken(cb);
        }

        public int Line
        {
            get { return _catchStatement.Line; }
        }

        public ISourceLocation CatchStatement
        {
            get { return _catchStatement; }
        }

        public ISourceLocation OpeningBrace
        {
            get { return _openingBrace; }
        }

        public ISourceLocation ClosingBrace
        {
            get { return _closingBrace; }
        }
    }
}