package calculator;

import java.util.List;
import java.util.Objects;

public class PositiveNumber {

    private static final PositiveNumber ZERO = new PositiveNumber(0);

    private final int value;

    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    public static PositiveNumber sum(List<PositiveNumber> numbers) {
        return numbers.stream()
                .reduce(PositiveNumber.ZERO, PositiveNumber::add);
    }

    public PositiveNumber add(PositiveNumber number) {
        return new PositiveNumber(value + number.value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final PositiveNumber that)) {
            return false;
        }
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public int getValue() {
        return value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");
        }
    }
}
