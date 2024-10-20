package calculator;

import java.util.Objects;

public class Number {

    private static final Number ZERO = new Number(0);
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public static Number from(String value) {
        if (value.isBlank()) {
            return ZERO;
        }

        return new Number(toInt(value));
    }

    private static int toInt(String value) {
        return Integer.parseInt(trim(value));
    }

    private static String trim(String value) {
        return value.trim();
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
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
