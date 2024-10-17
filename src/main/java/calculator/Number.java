package calculator;

import java.math.BigInteger;
import java.util.Objects;

public class Number {

    private static final int MAX_NUMBER_DIGITS = 30;

    private BigInteger value;

    private Number(BigInteger value) {
        validate(value);
        this.value = value;
    }

    public static Number ofZero() {
        return new Number(BigInteger.ZERO);
    }

    public static Number of(String value) {
        try {
            return new Number(new BigInteger(value));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 숫자 형식입니다.");
        }
    }

    public Number plus(Number number) {
        this.value = value.add(number.value);
        return this;
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

    private void validate(BigInteger value) {
        validateNonNegative(value);
        validateDigits(value);
    }

    private void validateNonNegative(BigInteger value) {
        if (value.signum() < 0) {
            throw new IllegalArgumentException("[ERROR] 숫자는 0 또는 양수여야 합니다.");
        }
    }

    private void validateDigits(BigInteger value) {
        String number = value.toString();
        if (number.length() > MAX_NUMBER_DIGITS) {
            throw new IllegalArgumentException("[ERROR] 숫자는 최대 30 자릿수를 초과할 수 없습니다.");
        }
    }
}
