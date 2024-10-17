package calculator.model;

import java.util.Objects;

public class Calculator {

    private int result;
    private static final String DEFAULT_DELIMITER = "[,:]";

    public void calculate(String input) {
        if (Objects.equals(input, "")) {
            result = 0;
            return;
        }
        String[] numbers;
        if (input.startsWith("//")) {
            String customDelimiter = String.valueOf(input.charAt(2));
            numbers = input.substring(5).split(customDelimiter);
            calculateSum(numbers);
        }
        if (input.charAt(0) - '0' >= 0) {
            numbers = input.split(DEFAULT_DELIMITER);
            calculateSum(numbers);
        }
    }

    private void calculateSum(String[] numbers) {
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
    }

    public int getResult() {
        return result;
    }
}
