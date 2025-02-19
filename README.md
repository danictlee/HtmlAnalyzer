EASTER_EGG_URLS 

(I must say that I'm now a huge fan the person who came up with this easter egg. I hope one day I'll be as cool as you!!)

@AUTHOR: DANIEL CHIN TAY LEE - danictlee@gmail.com

**Hey there!**

HtmlAnalyzer is an application developed as part of a technical test for a Software Development Intern role @Axur!

The application retrieves HTML content from a given URL, parses the HTML to extract the text located at the deepest nested level, and outputs that text.
**It also handles error scenarios, by printing "malformedHTML" for HTML structure issues and "URL connection error" if the content cannot be fetched (both messages without quotes)**.

# COMPLIANCE WITH REQUIREMENTS

Programming Language and Environment: The application is developed in Java, utilizing JDK 17, and is designed for compilation and execution via command-line interfaces.

Library Constraints: The project exclusively employs standard JDK libraries, specifically java.io, java.net, and java.util. It strictly avoids any external libraries or native JDK packages/classes related to HTML, XML, or DOM manipulation, such as those in javax.xml.

Compilation Simplicity: Positioned within the directory containing the application's source files, the program can be compiled with a single command:

```
javac HtmlAnalyzer.java 
```

# FEATURES:

HTML Fetching: Connects to a provided URL and reads the HTML content line by line.

HTML Parsing: Uses a stack-based approach to track HTML tag nesting. The parsing logic is refactored into helper methods (isTag, isClosingTag, extractTagName) for clarity.

Deepest Text Extraction: Identifies and returns the first text node at the deepest level of nesting.

Error Handling: Throws a custom MalformedHtmlException when tags are mismatched and handles URL connection issues with clear messages.

Modular Design: The solution is divided into distinct classes for fetching, parsing, and error handling, following OOP principles!

## REQUIRES JAVA DEVELOPMENT KIT (JDK) 17 OR HIGHER.

# PROJECT STRUCTURE

**HtmlAnalyzer.java:**

Serves as the entry point.
Validates input, coordinates fetching and parsing, and handles exceptions to print appropriate messages.

**HtmlFetcher.java:**

Connects to the URL and reads HTML content.
Uses a BufferedReader with try-with-resources for proper resource management.
Trims each line and ignores blank lines.

**HtmlParser.java:**

Processes the HTML content to determine the deepest nested text.
Utilizes a stack to track tag nesting and helper methods for tag detection and extraction.
Compares current nesting depth against the maximum to record the deepest text.

**MalformedHtmlException.java:**

A custom exception thrown when the HTML structure is invalid (e.g., mismatched or unclosed tags).

# HOW TO USE:

After compilation, run the application by using the following terminal comand :

```
java HtmlAnalyzer <URL>
```
example: 
input: java HtmlAnalyzer http://hiring.axreng.com/internship/example2.html
output: "This is in level 4. Correct result."