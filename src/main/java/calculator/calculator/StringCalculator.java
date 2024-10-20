package calculator.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*)\\\\n(.*)");

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = extractNumbers(input);
        validateNumbers(numbers);
        return sum(numbers);
    }

    private String[] extractNumbers(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = Pattern.quote(matcher.group(1));
            String numbersString = matcher.group(2);
            return numbersString.split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITERS);
    }

    private void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            if (number == null || number.trim().isEmpty()) {
                throw new IllegalArgumentException("빈 문자열이 있습니다.");
            }
        }
    }

    private int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(this::parseNumber)
                .sum();
    }

    private int parseNumber(String number) {
        try {
            int value = Integer.parseInt(number.trim());
            if (value < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 올바르지 않습니다.");
        }
    }
}