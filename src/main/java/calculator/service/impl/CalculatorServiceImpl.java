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
            delimiter = extractCustomDelimiter(input);
            input = input.substring(input.lastIndexOf("\\n") + 2);
        }

        validateCalculationString(input, delimiter);

        String[] numbers = input.split(delimiter);
        return sumNumbers(numbers);
    }

    private String extractCustomDelimiter(String input) {
        int delimiterEndIndex = input.lastIndexOf("\\n");
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException("Invalid input format");
        }

        String customDelimiter = input.substring(2, delimiterEndIndex);
        if (customDelimiter.isEmpty()) {
            return ",|:";
        }

        String[] delimitersArray = customDelimiter.split("");

        StringBuilder delimiterPattern = new StringBuilder();
        for (String delimiter : delimitersArray) {
            if (isNumeric(delimiter)) {
                throw new IllegalArgumentException("Custom delimiter cannot be a number: " + delimiter);
            }
            delimiterPattern.append(Pattern.quote(delimiter)).append("|");
        }

        delimiterPattern.append(",|:");

        return delimiterPattern.toString();
    }

    private void validateCalculationString(String input, String delimiter) {
        if (input.matches("^([" + delimiter + "]+).*") || input.matches(".*([" + delimiter + "]+)$")) {
            throw new IllegalArgumentException("Input cannot start or end with a delimiter.");
        }

        if (input.matches(".*([" + delimiter + "]{2,}).*")) {
            throw new IllegalArgumentException("Consecutive delimiters are not allowed.");
        }

        if (!delimiter.contains("-") && input.contains("-")) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            int num = Integer.parseInt(number);
            sum += num;
        }

        return sum;
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}