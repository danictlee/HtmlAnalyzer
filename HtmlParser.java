import java.util.*;

public class HtmlParser {
    public String findDeepestText(List<String> lines) throws MalformedHtmlException {
        int currentDepth = 0;
        int maxDepth = -1;
        String deepestText = null;
        Stack<String> tagStack = new Stack<>();

        for (String line : lines) {
            String trimmedLine = line.trim();
            if (isTag(trimmedLine)) {
                if (isClosingTag(trimmedLine)) {

                    String tagName = extractTagName(trimmedLine);
                    if (tagStack.isEmpty() || !tagStack.peek().equals(tagName)) {

                        throw new MalformedHtmlException();
                    }
                    tagStack.pop();
                    currentDepth--;
                } else {
                    String tagName = extractTagName(trimmedLine);
                    tagStack.push(tagName);
                    currentDepth++;
                }
            } else {
                if (currentDepth > maxDepth) {
                    maxDepth = currentDepth;
                    deepestText = trimmedLine;
                }
            }
        }
        if (!tagStack.isEmpty()) {
            throw new MalformedHtmlException();
        }
        return deepestText;
    }
    private boolean isTag(String line) {
        return line.startsWith("<") && line.endsWith(">");
    }

    private boolean isClosingTag(String line) {
        return line.startsWith("</");
    }
    private String extractTagName(String tagLine) {
        String content = tagLine.substring(1, tagLine.length() - 1);
        if (content.startsWith("/")) {
            content = content.substring(1);
        }
        return content.trim();
    }
}
