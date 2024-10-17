package calculator;

import java.util.Arrays;

public class Calculator {
    public int add(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
