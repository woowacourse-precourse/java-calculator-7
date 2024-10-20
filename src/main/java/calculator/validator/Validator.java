package calculator.validator;

import static calculator.exception.ErrorMessage.DIGIT_NOT_ALLOWED;
import static calculator.exception.ErrorMessage.DUPLICATE_DELIMITER;
import static calculator.exception.ErrorMessage.INVALID_LENGTH;

import calculator.exception.ExceptionHandler;

public class Validator {

    public void validateCustomDelimiter(String default_delimiter, String custom_delimiter) {
        if (custom_delimiter.length() != 1) {
            ExceptionHandler.throwIllegalArgException(INVALID_LENGTH);
        }
        if (Character.isDigit(custom_delimiter.charAt(0))) {
            ExceptionHandler.throwIllegalArgException(DIGIT_NOT_ALLOWED);
        }
        if (default_delimiter.contains(custom_delimiter)) {
            ExceptionHandler.throwIllegalArgException(DUPLICATE_DELIMITER);
        }
    }
}