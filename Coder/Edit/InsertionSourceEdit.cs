using System.Text;

namespace Coder.Edit
{
    public class InsertionSourceEdit : SourceEdit
    {
        private readonly string _content;

        public InsertionSourceEdit(string content)
        {
            _content = content;
        }

        public override void Apply(EditContext ctx, StringBuilder output)
        {
            output.Append(_content);
        }
    }
}