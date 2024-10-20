package calculator;

public class DelimiterResult {
    private final String delimiter;
    private final int startIndex;

    public DelimiterResult(String delimiter, int startIndex) {
        this.delimiter = delimiter;
        this.startIndex = startIndex;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public int getStartIndex() {
        return startIndex;
    }
}
