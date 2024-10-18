package parser;

public class ContentParser {
    private String contentSeparator;
    private String targetContent;
    private String[] parsedContent;

    public ContentParser(String contentSeparator, String targetContent) {
        this.targetContent = targetContent;
        this.contentSeparator = contentSeparator;
        parsing();
    }

    private void parsing() {
        parsedContent = targetContent.split(contentSeparator);
    }

    public String[] getParsedContent() {
        return parsedContent;
    }
}
