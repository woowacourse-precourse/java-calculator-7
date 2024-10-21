package calculator.model.vo;

import java.math.BigInteger;
import java.util.Objects;

public final class Number {

    private final BigInteger value;

    private Number(BigInteger number) {
        validatePositive(number);
        value = number;
    }

    public static Number of(String number) {
        if (number.isEmpty()) {
            return new Number(BigInteger.ZERO);
        }
        return new Number(new BigInteger(number));
    }

    public Number add(Number another) {
        return new Number(value.add(another.value));
    }

    private void validatePositive(BigInteger number) {
        if (number.compareTo(BigInteger.ZERO) == -1) {
            throw new IllegalArgumentException("양수만 입력하여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return value.toString();
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
        return Objects.equals(value, number.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
