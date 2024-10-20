package calculator.model;

public enum Opcode {
    PLUS("+");

    private final String symbol;

    Opcode(String symbol) {
        this.symbol = symbol;
    }

    public String getOpcode() {
        return symbol;
    }

}
