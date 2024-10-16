package calculator.domain;

import java.math.BigInteger;

public class Number {
    private final BigInteger value;

    public Number(String value) {
        this.value = validateNumber(value);
    }

    private BigInteger validateNumber(String value) {
        try {
            return new BigInteger(value);
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }
}
