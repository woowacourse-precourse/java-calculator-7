package calculator.constants;

public enum BasicSeparator implements EnumClass {
    COMMA(","),
    COLON(":");

    private final String symbol;

    BasicSeparator(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public Integer getSymbolLength() {
        return symbol.length();
    }
}
