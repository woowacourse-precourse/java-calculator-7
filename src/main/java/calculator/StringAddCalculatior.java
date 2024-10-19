package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculatior {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return sumWithDelimiter(numbers, customDelimiter);
        }
        return sumWithDelimiter(input, DEFAULT_DELIMITERS);
    }

    private static int sumWithDelimiter(String input, String delimiter) {
        String[] tokens = input.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            int number = parseNumber(token);
            validatePositive(number);
            sum += number;
        }
        return sum;
    }

    private static int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    private static void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
    }
}
