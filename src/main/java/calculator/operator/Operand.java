package calculator.operator;

import calculator.utils.ValueObject;

import java.util.Objects;

public class Operand extends ValueObject {
    private final int value;

    private Operand(int value) {
        this.value = value;
    }

    public static Operand of(int value) {
        return new Operand(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() == o.getClass()) {
            return value == ((Operand) o).value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
