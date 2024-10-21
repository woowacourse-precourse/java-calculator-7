package calculator.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {
    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String[] numbers;
        if (input.startsWith("//")) {
            numbers = getNumbersByCustomDelimiter(input);
        } else {
            numbers = input.split("[,:]");
        }

        return sum(numbers);
    }

    private String[] getNumbersByCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException();
        }
        String customDelimiter = matcher.group(1);
        return matcher.group(2).split(Pattern.quote(customDelimiter));
    }

    private int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += parseNumber(number.trim());
        }
        return sum;
    }

    private int parseNumber(String number) {
        try {
            int value = Integer.parseInt(number);
            if (value < 0) {
                throw new IllegalArgumentException();
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}