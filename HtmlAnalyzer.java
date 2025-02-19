import java.util.*;
import java.io.*;

public class HtmlAnalyzer {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("URL connection error");
            return;
        }
        try {
            HtmlFetcher fetcher = new HtmlFetcher();
            List<String> lines = fetcher.fetch(args[0]);

            HtmlParser parser = new HtmlParser();
            String deepestText = parser.findDeepestText(lines);

            if (deepestText != null) {
                System.out.println(deepestText);
            }
            
        } catch (MalformedHtmlException e) {
            System.out.println("malformed HTML");
        } catch (IOException e) {
            System.out.println("URL connection error");
        }
    }
}
