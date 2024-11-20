package calculator.service.domain;

import java.util.Arrays;
import java.util.Objects;

public class Number {
    private final double numberValue;

    public Number(double numberValue) {
        this.numberValue = numberValue;
    }

    public Number add(Number other) {
        return new Number(this.numberValue + other.numberValue);
    }

    @Override
    public String toString() {
        return String.valueOf(numberValue);
    }
}
