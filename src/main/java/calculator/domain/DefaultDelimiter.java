package calculator.domain;

public enum DefaultDelimiter {
    FIRST(","),
    SECOND(":");

    private final String delimiter;

    DefaultDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
