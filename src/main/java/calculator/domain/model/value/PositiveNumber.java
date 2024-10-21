package calculator.domain.model.value;

import java.util.Objects;

import static calculator.global.ErrorConst.NEED_POSITIVE_NUMBER;

public record PositiveNumber(long value) {

    public PositiveNumber {
        if (value <= 0) {
            throw new IllegalArgumentException(NEED_POSITIVE_NUMBER);
        }
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
