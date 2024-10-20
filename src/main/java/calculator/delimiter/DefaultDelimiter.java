package calculator.delimiter;

public enum DefaultDelimiter {
    COMMA(","),
    COLON(":"),
    ;

    private final String delimiter;

    DefaultDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
