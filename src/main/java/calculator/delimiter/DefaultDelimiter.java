package calculator.delimiter;

public enum DefaultDelimiter implements Delimiter {
    COMMA(','),
    COLON(':');

    private final char symbol;

    DefaultDelimiter(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
