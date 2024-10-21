package calculator.validator;

import calculator.global.exception.ErrorMessage;

public class NumberValidator {

    public static void validatePositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_ERROR.getMessage());
        }
    }
}
