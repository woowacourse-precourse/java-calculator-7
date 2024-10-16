package calculator.domain;

import java.math.BigInteger;

public class Number {
    final BigInteger value;

    public Number(String value) {
        this.value = new BigInteger(value);
    }
}
