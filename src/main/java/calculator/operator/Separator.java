package calculator.operator;

import calculator.utils.ValueObject;

public class Separator extends ValueObject {
    private final String symbol;

    private Separator(String seperatorString) {
        this.symbol = seperatorString;
    }

    public static Separator of(String symbol) {
        return new Separator(symbol);
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() == o.getClass()) {
            return symbol.equals(((Separator) o).symbol);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return symbol.hashCode();
    }
}
