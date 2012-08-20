namespace Coder.Edit
{
    public class EditContext
    {
        private readonly string _text;

        public EditContext(string text)
        {
            _text = text;
        }

        public string Text
        {
            get { return _text; }
        }

        public int CharacterOffset { get; set; }
    }
}