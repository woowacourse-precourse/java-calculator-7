package calculator.util;

import static calculator.message.Delimiter.CUSTOM_DELIMITER;
import static calculator.message.ErrorMessage.CUSTOM_DELIMITER_CANNOT_BE_NUMBER_MESSAGE;
import static calculator.message.ErrorMessage.EMPTY_ELEMENT_MESSAGE;
import static calculator.message.ErrorMessage.EMPTY_INPUT_MESSAGE;
import static calculator.message.ErrorMessage.INVALID_ELEMENT_MESSAGE;
import static calculator.message.ErrorMessage.INVALID_FLOAT_INPUT_MESSAGE;
import static calculator.message.ErrorMessage.NEGATIVE_NUMBER_MESSAGE;

import java.util.List;

public class Validator {
    public static String validateInput(String userInput) {
        isBlank(userInput);
        String newInput = validateCustomDelimiter(userInput);

        return newInput;
    }

    public static void isNegativeNumber(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < 0) {
                throw new IllegalArgumentException(NEGATIVE_NUMBER_MESSAGE);
            }
        });
    }

    public static String validateCustomDelimiter(String str) {
        if (str.length() >= 5 && str.startsWith("//") && str.charAt(3) == '\\' && str.charAt(4) == 'n') {
            setCustomDelimiter(str);
            validateCustomDelimiterIsNotNumber();
            return str.substring(5);
        }

        return str;
    }

    public static void validateElement(String element) {
        if (isBlankBetweenDelimiters(element)) {
            throw new IllegalArgumentException(EMPTY_ELEMENT_MESSAGE);
        }

        if (isFloat(element)) {
            throw new IllegalArgumentException(INVALID_FLOAT_INPUT_MESSAGE);
        }

        if (!isInteger(element)) {
            throw new IllegalArgumentException(INVALID_ELEMENT_MESSAGE);
        }
    }

    private static void isBlank(String str) {
        if (str.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_MESSAGE);
        }
    }

    private static boolean isBlankBetweenDelimiters(String element) {
        return element.isBlank();
    }

    private static boolean isFloat(String element) {
        try {
            Float.parseFloat(element);
            return element.contains(".");
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInteger(String element) {
        try {
            Integer.parseInt(element);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void validateCustomDelimiterIsNotNumber() {
        try {
            Integer.parseInt(CUSTOM_DELIMITER);
            throw new IllegalArgumentException(CUSTOM_DELIMITER_CANNOT_BE_NUMBER_MESSAGE);
        } catch (NumberFormatException e) {

        }
    }

    private static void setCustomDelimiter(String str) {
        CUSTOM_DELIMITER = String.valueOf(str.charAt(2));
    }
}