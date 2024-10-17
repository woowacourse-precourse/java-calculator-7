package calculator.constant;

public enum CustomDelimiterPattern {
    PREFIX("//"),
    SUFFIX("\n");

    private final String symbol;

    CustomDelimiterPattern(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
