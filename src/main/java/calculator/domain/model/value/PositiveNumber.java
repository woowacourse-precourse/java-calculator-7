package calculator.domain.model.value;

import java.util.Objects;

import static calculator.global.ErrorConst.NEED_POSITIVE_NUMBER;

public class PositiveNumber {

    public final long value;

    private PositiveNumber(Long value) {
        if (value < 0) {
            throw new IllegalArgumentException(NEED_POSITIVE_NUMBER);
        }
        this.value = value;
    }

    public static PositiveNumber from(final String value) {
        if (value.isEmpty()) {
            return new PositiveNumber(0L);
        }
        return new PositiveNumber(Long.parseLong(value));
    }


    public static PositiveNumber from(final Long value) {
        return new PositiveNumber(value);
    }

    public static PositiveNumber from(final long value) {
        return new PositiveNumber(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber that = (PositiveNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
