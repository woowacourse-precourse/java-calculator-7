package calculator.validator;

import calculator.global.exception.ErrorMessage;

public class StringValidator {

    public static void validateCustomDelimiterFormat(String str) {
        if (str.matches("\\d")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER_ERROR.getMessage());
        }
    }
}
