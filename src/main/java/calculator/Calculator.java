package calculator;

import java.util.Arrays;

public class Calculator {
    private int sum;
    private String delimiterPattern = "[,:]";

    private static final Calculator instance = new Calculator();

    private Calculator() {
    }

    public static Calculator getInstance() {
        return instance;
    }

    public int processString(String input) {
        String trimmedInput = input.trim();
        if (trimmedInput.isEmpty()) {
            sum = 0;
            return sum;
        }
        return Arrays.stream(trimmedInput.split(delimiterPattern))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
