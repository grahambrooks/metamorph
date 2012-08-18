using System.Text;

namespace CSharpQuery
{
    public abstract class SourceEdit
    {
        public static InsertionSourceEdit Insert(string content)
        {
            return new InsertionSourceEdit(content);
        }

        public PositionalSourceEdit At()
        {
            return new PositionalSourceEdit(this);
        }

        public abstract void Apply(string text, StringBuilder replacement);
    }

    public class PositionalSourceEdit : SourceEdit
    {
        private  int _characterOffset;
        private readonly SourceEdit _parent;

        public PositionalSourceEdit(SourceEdit parent)
        {
            _parent = parent;
        }

        public SourceEdit CharacterOffset(int offset)
        {
            _characterOffset = offset;
            return this;
        }

        public override void Apply(string input, StringBuilder output)
        {
            output.Append(input.Substring(0, _characterOffset));
            _parent.Apply(input, output);
            output.Append(input.Substring(_characterOffset));
        }
    }

    public class InsertionSourceEdit : SourceEdit
    {
        private readonly string _content;

        public InsertionSourceEdit(string content)
        {
            _content = content;
        }

        public override void Apply(string text, StringBuilder output)
        {
            output.Append(_content);
        }
    }
}