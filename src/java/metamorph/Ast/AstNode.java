package metamorph.Ast;

import java.util.ArrayList;

public class AstNode {
    private int type;
    private int line;
    private int charPositionInLine;
    private String text;
    private int index;
    private ArrayList<AstNode> children;

    public AstNode() {
        children = new ArrayList<AstNode>();
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getLine() {
        return line;
    }

    public int getCharPositionInLine() {
        return charPositionInLine;
    }

    public String getText() {
        return text;
    }

    public int getIndex() {
        return index;
    }

    public void setCharPositionInLine(int charPositionInLine) {
        this.charPositionInLine = charPositionInLine;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void addChild(AstNode child) {
        children.add(child);
    }

    public AstNode getChild(int index) {
        return children.get(index);
    }
}
