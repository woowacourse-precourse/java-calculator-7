package calculator.domain;

import static calculator.util.CalculatorConst.END_CUSTOM_DELIMITER;
import static calculator.util.CalculatorConst.START_CUSTOM_DELIMITER;

import calculator.util.ErrorMessage;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Division {
    private static int CUSTOM_DELIMITER_START_INDEX = 2;
    private static int START_NUMBER_INDEX = 2;

    private StringBuilder delimiter = new StringBuilder(":|,");

    public List<String> split(String input) {
        validateFormat(input);
        if (isCustomFormat(input)) {
            String customDelimiter = getCustomDelimiter(input);
            String digits = getDigits(input);
            validateCustomDelimiter(customDelimiter, digits);
            delimiter.append("|").append(customDelimiter);
            input = digits;
        }
        return Arrays.stream(input.split(delimiter.toString())).toList();
    }

    private static String getDigits(String input) {
        return input.substring(input.indexOf(END_CUSTOM_DELIMITER) + START_NUMBER_INDEX);
    }

    private static String getCustomDelimiter(String input) {
        return input.substring(input.indexOf(START_CUSTOM_DELIMITER)+CUSTOM_DELIMITER_START_INDEX , input.indexOf(
                END_CUSTOM_DELIMITER));
    }

    private void validateFormat(String input) {
        boolean isValidStart = input.isBlank() || isDigit(input) || isCustomFormat(input);
        if (!isValidStart) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT);
        }
    }

    private static boolean isCustomFormat(String input) {
        return input.startsWith(START_CUSTOM_DELIMITER) && input.contains(END_CUSTOM_DELIMITER);
    }

    private boolean isDigit(String input) {
        char[] charArray = input.toCharArray();
        if(charArray[0] == '-' && charArray.length > 1) {
            return Character.isDigit(charArray[1]);
        }
        return Character.isDigit(charArray[0]);
    }

    private void validateCustomDelimiter(String customDelimiter, String digits) {
        validateCustomFormat(customDelimiter, digits);
        validateCustomDuplicate(customDelimiter);
    }

    private void validateCustomFormat(String customDelimiter, String digits) {
        if (customDelimiter.isEmpty() || !isDigit(digits)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT);
        }
    }

    private void validateCustomDuplicate(String customDelimiter) {
        if (Pattern.matches(delimiter.toString(), customDelimiter)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_DELIMITER);
        }
    }


}
