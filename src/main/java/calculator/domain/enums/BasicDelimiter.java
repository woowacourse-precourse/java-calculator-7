package calculator.domain.enums;

public enum BasicDelimiter {
    COMMA(','),
    COLON(':');

    private final char symbol;

    BasicDelimiter(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
