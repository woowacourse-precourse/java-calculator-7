package calculator.domain;

import java.util.Objects;

public class Number {

    private int value;

    private Number(int value) {
        this.value = value;
    }

    public static Number from(int value) {
        return new Number(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return getValue() == number.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
