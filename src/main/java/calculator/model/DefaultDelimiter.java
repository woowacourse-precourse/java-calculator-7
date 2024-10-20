package calculator.model;

public enum DefaultDelimiter {

    COMMA(","), COLON(":");
    private final String symbol;

    DefaultDelimiter(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
