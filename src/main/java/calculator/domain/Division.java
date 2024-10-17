package calculator.domain;

import static calculator.util.CalculatorConst.END_DELIMITER;
import static calculator.util.CalculatorConst.START_DELIMITER;

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
        if (input.startsWith(START_DELIMITER)) {
            String customDelimiter = getCustomDelimiter(input);
            String digits = getDigits(input);
            validateCustomDelimiter(customDelimiter, digits);
            delimiter.append("|").append(customDelimiter);
            input = digits;
        }
        return Arrays.stream(input.split(delimiter.toString())).toList();
    }

    private static String getDigits(String input) {
        return input.substring(input.indexOf(END_DELIMITER) + START_NUMBER_INDEX);
    }

    private static String getCustomDelimiter(String input) {
        return input.substring(input.indexOf(START_DELIMITER)+CUSTOM_DELIMITER_START_INDEX , input.indexOf(END_DELIMITER));
    }

    private void validateFormat(String input) {
        boolean isValidStart = input.isBlank() || isDigit(input) || input.startsWith(START_DELIMITER);
        if (!isValidStart) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT);
        }
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
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER);
        }
    }

    private void validateCustomDuplicate(String customDelimiter) {
        if (Pattern.matches(delimiter.toString(), customDelimiter)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_DELIMITER);
        }
    }


}
