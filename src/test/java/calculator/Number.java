package calculator;

import java.math.BigInteger;

public class Number {
    private final BigInteger value;

    public Number(String value) {
        value = value.trim();
        validatePositiveNumber(value);
        this.value = new BigInteger(value);
    }

    private void validatePositiveNumber(String number) {
        if (!number.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
        }
    }

    public BigInteger getValue() {
        return value;
    }
}
