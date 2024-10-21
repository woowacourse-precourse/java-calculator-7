package calculator.model.vo;

import java.math.BigInteger;

public final class Number {

    private final BigInteger value;

    private Number(BigInteger number) {
        value = number;
    }

    public static Number of(String number) {
        return new Number(new BigInteger(number));
    }
}
