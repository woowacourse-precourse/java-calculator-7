package calculator.view.input.parser;

public enum Delimiter {
    COMMA(","),
    COLON(":");

    private final String delimiter;

    Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getSymbol() {
        return delimiter;
    }
}
