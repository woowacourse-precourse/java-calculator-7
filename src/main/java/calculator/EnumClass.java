package calculator;

public enum EnumClass {
    COMMA(","),
    COLON(":"),

    DESIGNATED_SEPARATOR_START("//"),
    DESIGNATED_SEPARATOR_END("\\n");

    private final String symbol;

    EnumClass(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public Integer getSymbolLength() {
        return symbol.length();
    }
}
