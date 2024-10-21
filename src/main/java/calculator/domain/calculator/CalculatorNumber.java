package calculator.domain.calculator;

import static calculator.constant.ExceptionMessage.INVALID_NUMBER_FORMAT;
import static calculator.constant.ExceptionMessage.NOT_POSITIVE_NUMBER;

import calculator.domain.visitor.NumberVisitor;

public class CalculatorNumber {
    private final long value;

    private CalculatorNumber(long value) {
        validatePositive(value);
        this.value = value;
    }

    public static CalculatorNumber from(String value) {
        try {
            return new CalculatorNumber(parseLong(value));

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.format(value));
        }
    }

    private static long parseLong(String value) {
        if (value.isEmpty()) {
            return 0;
        }

        return Long.parseLong(value);
    }

    private static void validatePositive(long value) {
        if (value <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER.message());
        }
    }

    public void accept(NumberVisitor visitor) {
        visitor.visit(this);
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CalculatorNumber that = (CalculatorNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(value);
    }
}
