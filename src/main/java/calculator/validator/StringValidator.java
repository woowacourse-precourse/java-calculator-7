package calculator.validator;

import calculator.global.exception.ErrorMessage;

public class StringValidator {

    private static final String DELIMITER_FORMAT_REGEX = "^[0-9-]*$";

    public static void validateCustomDelimiterFormat(String str) {
        if (str.matches(DELIMITER_FORMAT_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER_ERROR.getMessage());
        }
    }
}
