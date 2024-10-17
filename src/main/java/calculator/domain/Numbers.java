package calculator.domain;

import java.util.Arrays;

public class Numbers {

    private final int[] numbers;

    public Numbers(int[] numbers) {
        this.numbers = Arrays.copyOf(numbers, numbers.length);
    }

    public int sum() {
        return Arrays.stream(numbers).sum();
    }
}