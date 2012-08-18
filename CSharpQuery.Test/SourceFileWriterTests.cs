using System.IO;
using NUnit.Framework;

namespace CSharpQuery.Test
{
    [TestFixture]
    internal class SourceFileWriterTests
    {
        [Test]
        public void WriterCanWriteText()
        {
            const string expected = "Some simple text";

            var buffer = new StringWriter();

            var writer = new SourceFileWriter(buffer);

            writer.Write(expected);

            Assert.That(buffer.ToString(), Is.EqualTo(expected));
        }

        [Test]
        public void WriterCanReWriteInsertions()
        {
            const string original = "Some simple text";

            var buffer = new StringWriter();

            var writer = new SourceFileWriter(buffer);

            writer.ReWrite(original, SourceEdit.Insert("Graham ").At().CharacterOffset(5));

            Assert.That(buffer.ToString(), Is.EqualTo("Some Graham simple text"));
            
        }
    }
}