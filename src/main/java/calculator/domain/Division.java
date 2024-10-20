package calculator.domain;

import static calculator.util.CalculatorConst.END_CUSTOM_DELIMITER;
import static calculator.util.CalculatorConst.START_CUSTOM_DELIMITER;
import static calculator.util.ErrorMessage.*;

import calculator.util.ErrorMessage;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Division {
    private static int CUSTOM_DELIMITER_START_INDEX = 2;
    private static int START_NUMBER_INDEX = 2;

    private static final String DEFAULT_DELIMITER = ":|,";

    public static List<String> split(String input) {
        validateFormat(input);
        if (isCustomFormat(input)) {
            String customDelimiter = getCustomDelimiter(input);
            String digits = getDigits(input);
            validateCustomDelimiter(customDelimiter, digits);
            return List.of(digits.split(customDelimiter));
        }
        return List.of(input.split(DEFAULT_DELIMITER));
    }

    private static String getDigits(String input) {
        return input.substring(input.indexOf(END_CUSTOM_DELIMITER) + START_NUMBER_INDEX);
    }

    private static String getCustomDelimiter(String input) {
        return input.substring(input.indexOf(START_CUSTOM_DELIMITER)+CUSTOM_DELIMITER_START_INDEX , input.indexOf(
                END_CUSTOM_DELIMITER));
    }

    private static void validateFormat(String input) {
        boolean isValidStart = input.isBlank() || isDigit(input) || isCustomFormat(input);
        if (!isValidStart) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }

    private static boolean isCustomFormat(String input) {
        return input.startsWith(START_CUSTOM_DELIMITER) && input.contains(END_CUSTOM_DELIMITER);
    }

    private static boolean isDigit(String input) {
        char[] charArray = input.toCharArray();
        if(charArray[0] == '-' && charArray.length > 1) {
            return Character.isDigit(charArray[1]);
        }
        return Character.isDigit(charArray[0]);
    }

    private static void validateCustomDelimiter(String customDelimiter, String digits) {
        validateCustomFormat(customDelimiter, digits);
        validateCustomDuplicate(customDelimiter);
    }

    private static void validateCustomFormat(String customDelimiter, String digits) {
        if (customDelimiter.isEmpty() || !isDigit(digits)) {
            throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
        }
    }

    private static void validateCustomDuplicate(String customDelimiter) {
        if (Pattern.matches(DEFAULT_DELIMITER, customDelimiter)) {
            throw new IllegalArgumentException(DUPLICATE_DELIMITER.getMessage());
        }
    }


}
