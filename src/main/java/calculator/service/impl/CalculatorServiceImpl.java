package calculator.service.impl;

import calculator.service.CalculatorService;
import java.util.regex.Pattern;

public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int add(String input) throws IllegalArgumentException {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("Invalid input format");
            }
            String customDelimiter = input.substring(2, delimiterEndIndex);
            delimiter = Pattern.quote(customDelimiter) + "|,|:";
            input = input.substring(delimiterEndIndex + 1);
        }

        String[] numbers = input.split(delimiter);
        int sum = 0;

        for (String number : numbers) {
            if (!number.isEmpty()) {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    throw new IllegalArgumentException("Negative numbers are not allowed: " + num);
                }
                sum += num;
            }
        }

        return sum;
    }
}