package calculator.service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)"+"\\n"+"(.*)";
    private static final String DEFAULT_DELIMITERS = "[,:]";

    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String[] numbers;
        if (input.startsWith("//")) {
            numbers = splitWithCustomDelimiter(input);
        } else {
            numbers = input.split(DEFAULT_DELIMITERS);
        }

        return Arrays.stream(numbers)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .mapToInt(this::parseNumber)
                .sum();
    }

    private String[] splitWithCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }

        String delimiter = Pattern.quote(matcher.group(1));
        String numbers = matcher.group(2);
        return numbers.split(delimiter);
    }

    private int parseNumber(String number) {
        try {
            int value = Integer.parseInt(number);
            if (value < 0) {
                throw new IllegalArgumentException("음수는 사용할 수 없습니다: " + value);
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + number);
        }
    }
}