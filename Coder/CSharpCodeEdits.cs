using System.Collections.Generic;
using CSharpQuery;

namespace Coder
{
    public class CSharpCodeEdits : ICodeEdits
    {
        private Dictionary<int, List<SourceEdit>>  edits = new Dictionary<int, List<SourceEdit>>();
        public void Apply(SourceLine line, SourceFileWriter output)
        {
            if (edits.ContainsKey(line.LineNumber))
            {
                var e = edits[line.LineNumber];
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
            if (edits.ContainsKey(lineNumber))
            {
                edits[lineNumber].Add(edit);
            }
            else
            {
                edits.Add(lineNumber, new List<SourceEdit>(){edit});
            }
        }
    }
}