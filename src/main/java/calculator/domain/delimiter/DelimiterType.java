package calculator.domain.delimiter;

public enum DelimiterType {

    COMMA(","), COLON(":");

    private final String delimiter;

    DelimiterType(final String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
