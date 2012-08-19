using System;
using System.Collections.Generic;
using Antlr.Runtime;

namespace CSharpQuery
{
    internal class SourceStatement : ISourceLocation
    {
        private readonly int _line;
        private readonly int _charPositionInLine;
        private readonly string _text;

        private SourceStatement(int line, int charPositionInLine, string text)
        {
            _line = line;
            _charPositionInLine = charPositionInLine;
            _text = text;
        }

        public static SourceStatement FromToken(IToken t)
        {
            return new SourceStatement(t.Line, t.CharPositionInLine, t.Text);
        }

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
    }

    internal class CatchToken
    {
        private ISourceLocation catchStatement;
        private ISourceLocation openingBrace;
        private ISourceLocation closingBrace;
        private readonly int _line;

        public CatchToken(IToken ct)
        {
            catchStatement = SourceStatement.FromToken(ct);
        }
        public CatchToken(IToken ct, IToken ob, IToken cb)
        {
            catchStatement = SourceStatement.FromToken(ct);
            openingBrace = SourceStatement.FromToken(ob);
            closingBrace = SourceStatement.FromToken(cb);
        }

        public int Line
        {
            get { return catchStatement.Line; }
        }

        public ISourceLocation CatchStatement
        {
            get { return catchStatement; }
        }

        public ISourceLocation OpeningBrace
        {
            get { return openingBrace; }
        }
    }


    internal class DefaultQueryResults : IQueryResults
    {
        private readonly Dictionary<string, List<CatchToken>> _scannedFiles = new Dictionary<string, List<CatchToken>>();
        private readonly List<CatchToken> _catchStatements = new List<CatchToken>();
        private readonly List<CatchToken> _emptyCatchStatements = new List<CatchToken>();
        private List<CatchToken> _currentFileList = new List<CatchToken>();
        private readonly List<String> _erroredFiles = new List<string>();

        public void ProcessingFile(string filename)
        {
            ConsoleWriter.Tick();
            _currentFileList = new List<CatchToken>();
            _scannedFiles.Add(filename, _currentFileList);
        }

        public void ErrorProcessingFile(string filename)
        {
            _erroredFiles.Add(filename);
        }

        public void CatchFound(IToken token)
        {
            _catchStatements.Add(new CatchToken(token));
        }

        public void EmptyCatchFound(IToken catchToken, IToken openingBrace, IToken closingBrace)
        {
            _emptyCatchStatements.Add(new CatchToken(catchToken, openingBrace, closingBrace));
            _currentFileList.Add(new CatchToken(catchToken, openingBrace, closingBrace));
        }

        public void PrintSummaryToConsole()
        {
            PrintSummary(new ConsoleWriter());
        }

        public void PrintSummary(ConsoleWriter writer)
        {
            writer.WriteLine();
            writer.WriteLine("Query summary {0}", DateTime.Now);
            Separator(writer);
            writer.WriteLine("Files found                 {0}", _scannedFiles.Count + _erroredFiles.Count);
            writer.WriteLine("Successfully scanned        {0}", _scannedFiles.Count);
            writer.WriteLine("Catch blocks found          {0}", _catchStatements.Count);
            writer.WriteLine("Empty Catch blocks found    {0}", _emptyCatchStatements.Count);
            writer.WriteLine();


            foreach (var entry in _scannedFiles)
            {
                if (entry.Value.Count > 0)
                {
                    writer.WriteLine("{0} empty catch blocks found in {1}", entry.Value.Count, entry.Key);
                }
            }


            writer.WriteLine("");
            writer.WriteLine("Failed to scan:");
            Separator(writer);

            foreach (var erroredFile in _erroredFiles)
            {
                writer.Error("Error processing file {0}", erroredFile);
            }
        }

        private static void Separator(ConsoleWriter writer)
        {
            writer.WriteLine("----------------------------------------------------------------------");
        }

        public void EachFile(Action<string> action)
        {
            foreach (var pair in _scannedFiles)
            {
                if (pair.Value.Count > 0)
                {
                    action.Invoke(pair.Key);
                }
            }
        }

        public List<CatchToken> EmptyCatches(string filepath)
        {
            return _scannedFiles[filepath];
        }
    }
}