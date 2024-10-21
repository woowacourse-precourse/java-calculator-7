package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = splitNumbers(input);
        return sum(numbers);
    }

    private String[] splitNumbers(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String numbersString = matcher.group(2);
            return numbersString.split(Pattern.quote(customDelimiter));
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(this::parseNumber)
                .sum();
    }

    private int parseNumber(String number) {
        int value = Integer.parseInt(number);
        if (value < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
        }
        return value;
    }
}