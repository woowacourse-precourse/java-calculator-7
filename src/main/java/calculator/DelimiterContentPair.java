package calculator;

public class DelimiterContentPair {
    private final String content;
    private final String delimiter;

    public DelimiterContentPair(String content, String delimiter) {
        this.content = content;
        this.delimiter = delimiter;
    }

    public String getContent() {
        return content;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
