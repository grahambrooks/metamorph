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
            return new PositionalSourceEdit(this, 0);
        }

        public PositionalSourceEdit After(ISourceLocation sourceLocation)
        {
            return new PositionalSourceEdit(this, sourceLocation.EndCharacterOffset);
        }

        public IndentedLineEdit OnAnNewIndentedLine()
        {
            return new IndentedLineEdit(this);
        }


        public abstract void Apply(EditContext ctx, StringBuilder replacement);
    }
}