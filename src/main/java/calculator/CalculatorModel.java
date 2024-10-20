package calculator;

import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CalculatorModel {

    public int add(String input, Set<Character> delimiters) {
        String[] numbers = splitByDelimiters(input, delimiters);
        return Stream.of(numbers)
                .mapToInt(this::parsePositiveInteger)
                .sum();
    }

    private String[] splitByDelimiters(String input, Set<Character> delimiters) {
        String delimiterPattern = delimiters.stream()
                .map(c -> Pattern.quote(c.toString()))
                .reduce((a, b) -> a + "|" + b)
                .orElse("");
        return input.split(delimiterPattern);
    }

    private int parsePositiveInteger(String number) {
        if (number.isEmpty()) {
            return 0;
        }
        try {
            int parsedNumber = Integer.parseInt(number);
            validatePositiveNumber(parsedNumber);
            return parsedNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format: " + number);
        }
    }

    private void validatePositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed: " + number);
        }
    }
}
