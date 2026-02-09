import java.util.List;
import java.util.Stack;

public class HtmlParser {

    public String findDeepestText(List<String> lines) throws MalformedHtmlException {
        int currentDepth = 0;
        int maxDepth = -1;
        String deepestText = null;
        Stack<String> tagStack = new Stack<>();

        for (String line : lines) {
            if (isOpeningTag(line)) {
                String tagName = extractTagName(line);
                tagStack.push(tagName);
                currentDepth++;
            } else if (isClosingTag(line)) {
                String tagName = extractTagName(line);
                if (tagStack.isEmpty() || !tagStack.peek().equals(tagName)) {
                    throw new MalformedHtmlException();
                }
                
                tagStack.pop();
                currentDepth--;
            } else {
                if (currentDepth > maxDepth) {
                    maxDepth = currentDepth;
                    deepestText = line;
                }
            }
        }
        if (!tagStack.isEmpty()) {
            throw new MalformedHtmlException();
        }

        return deepestText;
    }

    private boolean isOpeningTag(String line) {
        return line.startsWith("<") && line.endsWith(">") && !line.startsWith("</");
    }

    private boolean isClosingTag(String line) {
        return line.startsWith("</") && line.endsWith(">");
    }

    private String extractTagName(String line) {
        String content = line.substring(1, line.length() - 1);
        if (content.startsWith("/")) {
            content = content.substring(1);
        }
        return content.trim();
    }
}