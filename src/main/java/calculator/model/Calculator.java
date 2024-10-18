package calculator.model;

import java.util.Arrays;

public class Calculator {
    public String calculate(int[] intArray) {
        int sum = Arrays.stream(intArray).sum();
        return String.valueOf(sum);
    }
}
