package calculator;

import java.util.Arrays;

public class Calculator {
    public int add(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
            throw new IllegalArgumentException();
            }
            sum += numbers[i];
        }
        return sum;
    }
}
