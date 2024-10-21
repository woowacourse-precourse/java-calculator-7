package calculator.domain.constant;

public enum Delimiter {
    CUSTOM_START("//"),
    CUSTOM_END("\\n"),
    DEFAULT(",|:");

    private final String delimiter;

    Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
