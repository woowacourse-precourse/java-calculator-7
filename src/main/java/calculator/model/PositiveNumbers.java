package calculator.model;

import static calculator.exception.ExceptionMessage.NOT_POSITIVE;

import java.util.Arrays;

public class PositiveNumbers {

    private final int[] numbers;

    public static PositiveNumbers getInstance(int[] numbers) {
        return new PositiveNumbers(numbers);
    }

    private PositiveNumbers(int[] numbers) {
        Arrays.stream(numbers).forEach(this::validatePositive);
        this.numbers = Arrays.copyOf(numbers, numbers.length);
    }

    public int sum() {
        return Arrays.stream(numbers).sum();
    }

    private void validatePositive(Integer number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE);
        }
    }
}
