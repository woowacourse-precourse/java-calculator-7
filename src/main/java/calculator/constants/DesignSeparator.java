package calculator.constants;

public enum DesignSeparator implements EnumClass {
    START("//"),
    END("\\n");

    private String symbol;

    DesignSeparator(String symbol) {
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
