package calculator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Number {

    private static final int SCALE = 2;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    private final BigDecimal value;

    private Number(BigDecimal value) {
        this.value = value.setScale(SCALE, ROUNDING_MODE);
    }

    public static Number from(String value) {
        try {
            return new Number(new BigDecimal(value));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + value);
        }
    }

    public Number add(Number other) {
        return new Number(this.value.add(other.value));
    }

    @Override
    public String toString() {
        String stringValue = value.stripTrailingZeros().toPlainString();
        return stringValue.endsWith(".") ? stringValue.substring(0, stringValue.length() - 1) : stringValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value.compareTo(number.value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}