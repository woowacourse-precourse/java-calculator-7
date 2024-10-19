package calculator.model;

import java.util.Arrays;

public class Numbers {

    private int[] numbers;

    public void setNumbers(int[] numbers) {
        this.numbers = numbers.clone();
    }

    public int sum() {
        return Arrays.stream(numbers).sum();
    }
}
