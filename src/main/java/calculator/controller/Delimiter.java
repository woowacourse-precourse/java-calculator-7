package calculator.controller;

public enum Delimiter {
    COMMA(","), COLON(":");

    private final String delimiter;

    Delimiter(String delimeter) {
        this.delimiter = delimeter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
