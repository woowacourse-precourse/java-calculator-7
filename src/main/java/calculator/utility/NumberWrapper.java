package calculator.utility;

import java.math.BigInteger;


public class NumberWrapper {

    private BigInteger value;

    public static final NumberWrapper ZERO = new NumberWrapper(BigInteger.ZERO);

    public NumberWrapper(String value) {
        this.value = new BigInteger(value);
    }

    public NumberWrapper(BigInteger value) {
        this.value = value;
    }

    public BigInteger getValue() {
        return value;
    }

    public int compareTo(NumberWrapper other) {
        return this.value.compareTo(other.getValue());
    }

    public NumberWrapper add(NumberWrapper other) {
        return new NumberWrapper(this.value.add(other.getValue()));
    }
}
