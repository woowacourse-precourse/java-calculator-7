package calculator.model;

import calculator.util.InputValidator;
import java.util.Arrays;
public class Calculator {
    public static int calculate(String input) {
        String[] numbers = StringDelimiter.parse(input);

        InputValidator.validateNegativeNumbers(Arrays.asList(numbers));

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
        }

        return sum;
    }
}