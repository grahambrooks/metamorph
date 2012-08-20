using System.Collections.Generic;
using System.IO;
using NUnit.Framework;

namespace Coder.Test
{
    [TestFixture]
    public class SourceFileReaderTests
    {
        [TestCase]
        public void EachLineIncludesLineNumber()
        {
            const string source = @"Line 1
Line 2";
            var reader = new SourceFileReader(new StringReader(source));

            var lines = new List<SourceLine>();
            reader.EachLine(lines.Add);

            Assert.That(lines.Count, Is.EqualTo(2));
            Assert.That(lines[0].LineNumber, Is.EqualTo(1));
            Assert.That(lines[1].LineNumber, Is.EqualTo(2));
        }
        [TestCase]
        public void EachLineIncludesLineText()
        {
            const string source = @"Line 1
Line 2";
            var reader = new SourceFileReader(new StringReader(source));

            var lines = new List<SourceLine>();
            reader.EachLine(lines.Add);

            Assert.That(lines[0].Text, Is.EqualTo("Line 1"));
            Assert.That(lines[1].Text, Is.EqualTo("Line 2"));
        }
    }
}
