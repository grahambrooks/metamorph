package metamorph.java

object Tool {
  def main(args: Array[String]) {
    val tool = new Tool(new DefaultJavaFileProcessor())

    tool.run(args)
  }
}

class Tool(processor: JavaFileProcessor) {
  def run(args: Array[String]) {

    args foreach (arg => processor.processFile(arg))
  }
}
