package calculator.controller;

import java.util.Arrays;

public class Validation {

    private static final String CUSTOM_DELIMITER_REGEX = "^(//.?\\n).*$";
    private static final int ZERO = 0;

    public static boolean hasCustomDelimiter(String input) {
        if (input.matches(CUSTOM_DELIMITER_REGEX)) {
            return true;
        }
        return false;
    }

    public static boolean isAllPositive(int[] numbers) {
        return Arrays.stream(numbers).allMatch(number -> number > ZERO);
    }
}
