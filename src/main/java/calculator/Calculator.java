package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String POSITIVE_NUMBER_ERROR = "양수만 허용됩니다: ";
    private static final String INVALID_NUMBER_ERROR = "잘못된 숫자 형식입니다: ";
    private static final String INVALID_CUSTOM_DELIMITER_ERROR = "잘못된 커스텀 구분자 형식입니다";

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return addWithCustomDelimiter(input);
        }

        return sumNumbers(parseInput(input, DEFAULT_DELIMITERS));
    }

    private int addWithCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER_ERROR);
        }
        String customDelimiter = Pattern.quote(matcher.group(1));
        String numbersPart = matcher.group(2);
        return sumNumbers(parseInput(numbersPart, customDelimiter));
    }

    private int[] parseInput(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .mapToInt(this::parseNumber)
                .toArray();
    }

    private int parseNumber(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException(POSITIVE_NUMBER_ERROR + number);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR + token, e);
        }
    }

    private int sumNumbers(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}