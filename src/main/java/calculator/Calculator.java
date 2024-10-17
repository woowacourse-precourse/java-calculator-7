package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String NEGATIVE_NUMBER_ERROR = "음수는 허용되지 않습니다";
    private static final String INVALID_NUMBER_ERROR = "잘못된 숫자 형식입니다";
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

    public int addWithCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER_ERROR);
        }
        String customDelimiter = matcher.group(1);
        String numbersPart = matcher.group(2);
        return sumNumbers(parseInput(numbersPart, Pattern.quote(customDelimiter)));
    }

    public int[] parseInput(String input, String delimiter) {
        String[] tokens = input.split(delimiter + "|\n");
        return Arrays.stream(tokens)
                .mapToInt(this::parseNumber)
                .toArray();
    }

    public int parseNumber(String token) {
        try {
            int number = Integer.parseInt(token.trim());
            if (number < 0) {
                throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR, e);
        }
    }

    public int sumNumbers(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}