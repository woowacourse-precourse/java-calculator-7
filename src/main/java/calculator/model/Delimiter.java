package calculator.model;

public enum Delimiter {

    COMMA(","), COLON(":");
    private final String symbol;

    Delimiter(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
