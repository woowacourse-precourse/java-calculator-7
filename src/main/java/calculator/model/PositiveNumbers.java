package calculator.model;

import calculator.constants.ErrorMessage;

import java.util.List;

public class PositiveNumbers {
    private final List<Integer> numbers;

    public PositiveNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validatePositive(numbers);
    }

    private void validatePositive(List<Integer> numbers) {
        numbers.forEach((number) -> {
            if (number <= 0) {
                throw new IllegalArgumentException(ErrorMessage.ONLY_ALLOWED_POSITIVE_NUMBER);
            }
        });
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
