package calculator.util;

public enum Delimiters {
    COMMA(","),
    COLON(":"),
    NEGATIVE("-");

    private final String symbol;

    Delimiters(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static String getRegex() {
        return String.join("|", COMMA.symbol, COLON.symbol, NEGATIVE.symbol);
    }
}
