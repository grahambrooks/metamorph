using System.Collections.Generic;
using Coder.Edit;

namespace Coder
{
    public class CSharpCodeEdits : ICodeEdits
    {
        private readonly Dictionary<int, List<SourceEdit>>  _edits = new Dictionary<int, List<SourceEdit>>();
        public void Apply(SourceLine line, SourceFileWriter output)
        {
            if (_edits.ContainsKey(line.LineNumber))
            {
                var e = _edits[line.LineNumber];
                foreach (var sourceEdit in e)
                {
                    output.ReWrite(line.Text, sourceEdit);
                }
            }
            else
            {
                output.WriteLine(line.Text);
            }
        }

        public void Add(int lineNumber, SourceEdit edit)
        {
            if (_edits.ContainsKey(lineNumber))
            {
                _edits[lineNumber].Add(edit);
            }
            else
            {
                _edits.Add(lineNumber, new List<SourceEdit>(){edit});
            }
        }
    }
}