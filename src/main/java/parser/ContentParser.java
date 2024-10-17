package parser;

public class ContentParser {
    private String contentDelimiter;
    private String targetContent;
    private String[] parsedContent;

    public ContentParser(String contentDelimiter, String targetContent) {
        this.targetContent = targetContent;
        this.contentDelimiter = contentDelimiter;
        Parsing();
    }

    private void Parsing() {
        parsedContent = targetContent.split(contentDelimiter);
    }

    public String[] getParsedContent() {
        return parsedContent;
    }
}
