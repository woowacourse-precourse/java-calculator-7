package calculator;

import java.util.Arrays;

public class Calculator {
    private String delimiterPattern = "[,:]";

    private static final Calculator instance = new Calculator();

    private Calculator() {
    }

    public static Calculator getInstance() {
        return instance;
    }

    public int processString(String input) {
        int sum = 0;
        input = input.trim();
        if (input.isEmpty()) {
            return sum;
        }
        if (input.startsWith("//")) {
            input = processCustomDelimiter(input);
        }
        return Arrays.stream(input.split(delimiterPattern))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public String processCustomDelimiter(String input) {
        int delimiterIndex = input.indexOf("\\n");
        String customDelimiter = input.substring(2, delimiterIndex);
        delimiterPattern = customDelimiter + "|" + delimiterPattern;
        return input.substring(delimiterIndex + 2);
    }
}
