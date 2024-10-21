package calculator;

import java.util.Arrays;

public class Calculator {
    public static int calculateSum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
