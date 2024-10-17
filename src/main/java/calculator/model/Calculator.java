package calculator.model;

import static calculator.validate.NumberValidator.validateNumber;

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
            return;
        }
        numbers = input.split(DEFAULT_DELIMITER);
        calculateSum(numbers);
    }

    private void calculateSum(String[] numbers) {
        for (String number : numbers) {
            try {
                validateNumber(number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                throw e;
            }
            result += Integer.parseInt(number);
        }
    }

    public int getResult() {
        return result;
    }
}
