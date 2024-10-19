package calculator;

public enum Delimiter {

    COMMA(","),
    COLON(":"),
    CUSTOM_DOUBLE_SLASH("//");

    private final String delimiter;

    Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
