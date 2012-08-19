using System.Text;

namespace CSharpQuery
{
    public class PositionalSourceEdit : SourceEdit
    {
        private  int _characterOffset;
        private readonly SourceEdit _parent;

        public PositionalSourceEdit(SourceEdit parent, int characterOffset)
        {
            _parent = parent;
            _characterOffset = characterOffset;
        }

        public SourceEdit CharacterOffset(int offset)
        {
            _characterOffset = offset;
            return this;
        }

        public override void Apply(EditContext ctx, StringBuilder output)
        {
            ctx.CharacterOffset = _characterOffset;
            output.Append(ctx.Text.Substring(0, _characterOffset));
            _parent.Apply(ctx, output);
            output.Append(ctx.Text.Substring(_characterOffset));
        }
    }
}