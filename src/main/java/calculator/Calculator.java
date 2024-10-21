package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final int ZERO = 0;
    private static final String DELIMITER = ",|:";
    private static final String NUMBER_RANGE_ERROR_MESSAGE = "양수를 입력해주세요.";
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자를 입력해주세요.";
    private static final String LINE_BREAK = "\n";
    private static final String ESCAPE_LINE_BREAK = "\\n";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)" + ESCAPE_LINE_BREAK + "(.*)";
    private static final int DELIMITER_INDEX = 1;
    private static final int TOKEN_INDEX = 2;

    public static int calculate(String input) {
        if (isBlank(input)) {
            return ZERO;
        }
        return sum(splitByCustomDelimiter(input));
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private static String[] splitByCustomDelimiter(String input) {
        input = input.replace(ESCAPE_LINE_BREAK, LINE_BREAK);
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (m.find()) {
            return extractTokens(m);
        }
        return splitByDefault(input);
    }

    private static String[] extractTokens(Matcher m) {
        String customDelimiter = m.group(DELIMITER_INDEX);
        return m.group(TOKEN_INDEX).split(customDelimiter);
    }

    private static String[] splitByDefault(String input) {
        return input.split(DELIMITER);
    }

    private static int sum(String[] values) {
        return Arrays.stream(values)
                .mapToInt(Calculator::toInt)
                .sum();
    }

    private static int toInt(String input) {
        int number = parseNumber(input);
        validatePositive(number);
        return parseNumber(input);
    }

    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private static void validatePositive(int number) {
        if (number < ZERO) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
    }
}
