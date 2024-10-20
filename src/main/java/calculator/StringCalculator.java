package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return calculateSum(numbers, customDelimiter);
        }

        return calculateSum(input, DEFAULT_DELIMITERS);
    }

    private static int calculateSum(String input, String delimiter) {
        String[] tokens = input.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            sum += parseNumber(token);
        }
        return sum;
    }

    private static int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 값: " + token);
        }
    }
}