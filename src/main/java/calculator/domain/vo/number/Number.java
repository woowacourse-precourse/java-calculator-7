package calculator.domain.vo.number;

import static calculator.infrastructure.exception.ErrorCode.*;

import java.math.BigInteger;
import java.util.Objects;

public class Number {

    private BigInteger value;

    private Number(final String value) {
        validate(value);
        this.value = new BigInteger(value);
    }

    protected void validate(final String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException();
        }

        try {
            new BigInteger(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
        }
    }

    public static Number from(final String value) {
        return new Number(value);
    }

    public BigInteger getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Number)) {
            return false;
        }
        Number number = (Number) o;
        return this.value.equals(number.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.format("Number = %s", value);
    }

}
