package calculator.model;

import java.util.Arrays;

public class PositiveNumbers {

    private final int[] numbers;

    public static PositiveNumbers getInstance(int[] numbers) {
        return new PositiveNumbers(numbers);
    }

    private PositiveNumbers(int[] numbers) {
        this.numbers = Arrays.copyOf(numbers, numbers.length);
    }

    public int sum() {
        return Arrays.stream(numbers).sum();
    }
}
