package calculator.validator;

import static calculator.exception.ErrorMessage.DIGIT_NOT_ALLOWED;
import static calculator.exception.ErrorMessage.DUPLICATE_DELIMITER;
import static calculator.exception.ErrorMessage.INVALID_LENGTH;
import static calculator.exception.ErrorMessage.INVALID_NUMBER;
import static calculator.exception.ErrorMessage.NEGATIVE_NUMBER;

import calculator.exception.ExceptionHandler;

public class Validator {

    public int toPositiveInteger(String value) {
        try {
            int number = Integer.parseInt(value);
            if (number < 0) {
                ExceptionHandler.throwIllegalArgException(NEGATIVE_NUMBER, value);
            }
            return number;
        } catch (NumberFormatException e) {
            ExceptionHandler.throwIllegalArgException(INVALID_NUMBER, value);
            return 0; // 도달하지 않음
        }
    }

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