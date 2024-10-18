package parser;

public class ContentParser {
    private String contentDelimiter;
    private String targetContent;
    private String[] parsedContent;

    public ContentParser(String contentDelimiter, String targetContent) {
        this.targetContent = targetContent;
        this.contentDelimiter = contentDelimiter;
        parsing();
    }

    private void parsing() {
        parsedContent = targetContent.split(contentDelimiter);
    }

    public String[] getParsedContent() {
        return parsedContent;
    }
}
