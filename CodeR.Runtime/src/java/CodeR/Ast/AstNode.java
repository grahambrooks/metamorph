package CodeR.Ast;

import java.util.ArrayList;
import java.util.List;

public class AstNode {
    private int type;
    private int line;
    private int charPositionInLine;
    private String text;
    private int index;
    private List<AstNode> children;

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

    public void setcharPositionInLine(int charPositionInLine) {
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
}
