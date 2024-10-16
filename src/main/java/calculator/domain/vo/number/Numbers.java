package calculator.domain.vo.number;

import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Number> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static Numbers from(final List<Number> numbers) {
        return new Numbers(numbers);
    }
}
