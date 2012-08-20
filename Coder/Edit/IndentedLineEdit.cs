using System.Text;

namespace Coder.Edit
{
    public class IndentedLineEdit : SourceEdit
    {
        private readonly SourceEdit _parent;

        public IndentedLineEdit(SourceEdit parent)
        {
            _parent = parent;
        }

        public override void Apply(EditContext ctx, StringBuilder replacement)
        {
            replacement.Append("\n");
            for (int i = 0; i < ctx.CharacterOffset + 3; i++)
            {
                replacement.Append(' ');
            }
            _parent.Apply(ctx, replacement);
        }
    }
}