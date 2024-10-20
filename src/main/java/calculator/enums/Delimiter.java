package calculator.enums;

public enum Delimiter {
    COMMA(','),
    COLON(':');

    private final char delimiter;

    Delimiter(char delimiter) {
        this.delimiter = delimiter;
    }

    public char getDelimiter() {
        return delimiter;
    }
}
