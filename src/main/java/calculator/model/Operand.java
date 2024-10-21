package calculator.model;

public class Operand {

    private long number;

    public Operand(long number) {
        this.number = number;
    }

    public long getNumber() {
        return this.number;
    }

    public boolean isPositiveNumber() {
        return this.number > 0;
    }
}
