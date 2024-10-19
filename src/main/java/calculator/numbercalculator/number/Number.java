package calculator.numbercalculator.number;

import java.math.BigInteger;

public record Number(BigInteger value) {

    public Number {
        validate(value);
    }

    public static Number of(String value) {
        BigInteger digit = toInteger(value);
        return new Number(digit);
    }

    private void validate(BigInteger value) {
        if (isNotPositive(value)) {
            throw new IllegalArgumentException("숫자는 양수만 올 수 있습니다.");
        }
    }

    private boolean isNotPositive(BigInteger value) {
        return value.compareTo(BigInteger.ZERO) <= 0;
    }

    private static BigInteger toInteger(String value) {
        try {
            return new BigInteger(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없습니다.");
        }
    }
}
