package metamorph.parsing;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;
import org.antlr.v4.runtime.misc.Utils;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.Tree;

import java.util.Arrays;
import java.util.List;

public class PrintingListener {
    public static String toStringTree(@NotNull Tree t, @Nullable Parser recog) {
        String[] ruleNames = recog != null ? recog.getRuleNames() : null;
        List<String> ruleNamesList = ruleNames != null ? Arrays.asList(ruleNames) : null;
        return toStringTree(t, ruleNamesList);
    }

    public static String toStringTree(@NotNull Tree t, @Nullable List<String> ruleNames) {
        String s = Utils.escapeWhitespace(getNodeText(t, ruleNames), false);
        if (t.getChildCount() == 0) return s;
        StringBuilder buf = new StringBuilder();
        buf.append("(");
        s = Utils.escapeWhitespace(getNodeText(t, ruleNames), false);
        buf.append(s);
        buf.append(' ');
        for (int i = 0; i < t.getChildCount(); i++) {
            if (i > 0) buf.append(' ');
            buf.append(toStringTree(t.getChild(i), ruleNames));
        }
        buf.append(")");
        return buf.toString();
    }

    public static String getNodeText(@NotNull Tree t, @Nullable Parser recog) {
        String[] ruleNames = recog != null ? recog.getRuleNames() : null;
        List<String> ruleNamesList = ruleNames != null ? Arrays.asList(ruleNames) : null;
        return getNodeText(t, ruleNamesList);
    }

    public static String getNodeText(@NotNull Tree t, @Nullable List<String> ruleNames) {
        if (ruleNames != null) {
            if (t instanceof RuleNode) {
                int ruleIndex = ((RuleNode) t).getRuleContext().getRuleIndex();
                String ruleName = ruleNames.get(ruleIndex);
                return ruleName;
            } else if (t instanceof ErrorNode) {
                return t.toString();
            } else if (t instanceof TerminalNode) {
                Object symbol = ((TerminalNode<?>) t).getSymbol();
                if (symbol instanceof Token) {
                    String s = ((Token) symbol).getText();
                    return s;
                }
            }
        }
        // no recog for rule names
        Object payload = t.getPayload();
        if (payload instanceof Token) {
            return ((Token) payload).getText();
        }
        return t.getPayload().toString();
    }
}
