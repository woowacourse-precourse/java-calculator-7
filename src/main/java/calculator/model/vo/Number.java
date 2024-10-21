package calculator.model.vo;

import java.math.BigInteger;

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

    private void validatePositive(BigInteger number) {
        if (number.compareTo(BigInteger.ZERO) == -1) {
            throw new IllegalArgumentException("양수만 입력하여야 합니다.");
        }
    }
}
