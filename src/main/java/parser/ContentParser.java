package parser;

public class ContentParser {
    private String separator;
    private String[] parsedContent;

    public ContentParser(String separator) {
        this.separator = separator;
    }

    public String[] parse(String targetContent) {
        parsedContent = targetContent.split(separator);
        return parsedContent;
    }
}
