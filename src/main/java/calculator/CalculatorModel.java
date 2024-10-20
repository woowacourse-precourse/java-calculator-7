package calculator;

import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CalculatorModel {

    public int add(String input, Set<Character> delimiters) {
        String[] numbers = splitByDelimiters(input, delimiters);
        return Stream.of(numbers)
                .mapToInt(this::parsePositiveInteger)  // 빈 문자열도 처리
                .sum();
    }

    public String[] splitByDelimiters(String input, Set<Character> delimiters) {
        String delimiterPattern = delimiters.stream()
                .map(c -> Pattern.quote(c.toString()))
                .reduce((a, b) -> a + "|" + b)
                .orElse("");

        return input.split(delimiterPattern);
    }

    private int parsePositiveInteger(String number) {
        if (number.isEmpty()) {
            return 0; // 빈 문자열을 0으로 처리
        }

        try {
            int parsedNumber = Integer.parseInt(number);
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed");
            }
            return parsedNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format");
        }
    }
}
