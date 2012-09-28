package CodeR.Java;

public class Tool {
    private JavaFileProcessor processor;

    public static void main(String args[]) {
        Tool tool = new Tool(new DefaultJavaFileProcessor());

        tool.run(args);

    }

    public Tool(JavaFileProcessor processor) {

        this.processor = processor;
    }

    public void run(String[] args) {
        for (String arg : args) {
            processor.processFile(arg);
        }
    }

}
