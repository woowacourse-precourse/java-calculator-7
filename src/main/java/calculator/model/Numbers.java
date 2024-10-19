package calculator.model;

import java.util.Arrays;

public class Numbers {

    private final int[] numbers;

    public Numbers(int[] numbers) {
        this.numbers = numbers;
    }

    public int getSumResult() {
        return Arrays.stream(numbers).sum();
    }
}
