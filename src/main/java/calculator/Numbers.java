package calculator;

import java.util.Arrays;

public class Numbers {
    private final int[] numbers;

    public Numbers(int[] numbers) {
        this.numbers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            validate(numbers[i]);
            this.numbers[i] = numbers[i];
        }
    }

    private void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("양수만 입력하실 수 있습니다.");
        }
    }

    public int calculateSum() {
        return Arrays.stream(numbers).sum();
    }
}