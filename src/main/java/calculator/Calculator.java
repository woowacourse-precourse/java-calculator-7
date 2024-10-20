package calculator;

import java.util.Arrays;

public class Calculator {
    public Calculator() {
    }

    public int getSummary(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
