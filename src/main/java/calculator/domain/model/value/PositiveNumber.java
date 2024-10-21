package calculator.domain.model.value;

import java.util.Objects;

public record PositiveNumber(long value) {

    public PositiveNumber {
        if (value <= 0) {
            throw new IllegalArgumentException("양수를 입력해야 합니다.");
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
