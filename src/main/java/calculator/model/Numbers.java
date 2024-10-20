package calculator.model;

import calculator.model.exception.NotAllowedNumberException;

import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    // Constructor
    private Numbers(List<Integer> numbers) {
        validateMinusNumber(numbers);
        this.numbers = numbers;
    }

    public static Numbers of(List<Integer> source) {
        return new Numbers(source);
    }

    // Validation
    private void validateMinusNumber(List<Integer> numbers) {
        numbers.forEach(this::checkIsMinus);
    }

    private void checkIsMinus(Integer num) {
        if (num < 0) {
            throw new NotAllowedNumberException();
        }
    }

    // Domain Logic
    public Integer sum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
