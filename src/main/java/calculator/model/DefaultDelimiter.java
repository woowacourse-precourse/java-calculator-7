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

    public static boolean hasDefaultDelimiter(String input) {
        return input.contains(COMMA.symbol) || input.contains(COLON.symbol);
    }
}
