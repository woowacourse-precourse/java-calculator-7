package calculator.util;

import static calculator.message.Delimiter.CUSTOM_DELIMITER;
import static calculator.message.ErrorMessage.CUSTOM_DELIMITER_CANNOT_BE_NUMBER_MESSAGE;
import static calculator.message.ErrorMessage.EMPTY_INPUT_MESSAGE;
import static calculator.message.ErrorMessage.NEGATIVE_NUMBER_MESSAGE;

import java.util.List;

public class Validator {
    public static String validateInput(String userInput) {
        isBlank(userInput);
        String newInput = validateCustomDelimiter(userInput);

        return newInput;
    }

    private static void isBlank(String str) {
        if (str.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_MESSAGE);
        }
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