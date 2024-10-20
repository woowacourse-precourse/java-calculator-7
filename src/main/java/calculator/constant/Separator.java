package calculator.constant;

public enum Separator {
    COMMA(","),
    COLON(":");

    private final String symbol;

    Separator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
