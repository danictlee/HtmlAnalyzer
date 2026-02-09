import java.io.IOException;
import java.util.List;

public class HtmlAnalyzer {
    public static void main(String[] args) {
        if (args.length == 0) { 
            return; 
        }

        String url = args[0];

        try {
            HtmlFetcher fetcher = new HtmlFetcher();
            List<String> lines = fetcher.fetch(url);

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