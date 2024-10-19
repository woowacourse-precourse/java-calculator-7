package calculator.controller;

import java.util.Arrays;

public class Validation {

    private static final String CUSTOM_DELIMITER_REGEX = "^(//.?\\\\n).*$";
    private static final int ZERO = 0;
    private static final int DEFAULT_DELIMITER_LENGTH = 3;

    public static boolean hasCustomDelimiter(String input) {
        return input.matches(CUSTOM_DELIMITER_REGEX);
    }

    public static boolean isAllNumbers(String[] tokens) {
        return Arrays.stream(tokens).allMatch(token -> token.chars().allMatch(Character::isDigit));
    }

    public static boolean isAllPositive(int[] numbers) {
        return Arrays.stream(numbers).allMatch(number -> number > ZERO);
    }

    public static boolean isDefaultDelimiter(String delimiter) {
        return delimiter.length() == DEFAULT_DELIMITER_LENGTH;
    }
}
