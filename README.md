# EASTER_EGG_URLS

# HtmlAnalyzer

HTML analyzer that finds the text at the deepest nesting level of a web page.

## Usage

### Compile

```bash
javac *.java
```

### Run

```bash
java HtmlAnalyzer <URL>
```

**Example:**

```bash
java HtmlAnalyzer http://hiring.axreng.com/internship/example1.html
```

## Project Structure

- `HtmlAnalyzer.java` - Main class
- `HtmlFetcher.java` - Fetches HTML content from a URL
- `HtmlParser.java` - Parses HTML and finds the deepest text
- `MalformedHtmlException.java` - Exception for malformed HTML

## Output

- **Success:** Prints the text found at the deepest level
- **Malformed HTML:** `malformed HTML`
- **Connection error:** `URL connection error`
