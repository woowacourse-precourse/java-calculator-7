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

    public Opcode of(char symbol) {
        if (symbol == '+') {
            return PLUS;
        }
        return null;
    }
}
