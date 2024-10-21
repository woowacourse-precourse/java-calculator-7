package calculator;

import java.util.Arrays;

public class Calculator {
    private static final int ZERO = 0;
    private static final String DELIMITER = ",|:";
    private static final String NUMBER_RANGE_ERROR_MESSAGE = "양수를 입력해주세요.";
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자를 입력해주세요.";

    public static int calculate(String input) {
        if (isBlank(input)) {
            return ZERO;
        }
        return sum(input.split(DELIMITER));
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private static int sum(String[] values) {
        return Arrays.stream(values)
                .mapToInt(Calculator::toInt)
                .sum();
    }

    private static int toInt(String input) {
        int number = parseNumber(input);;
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
