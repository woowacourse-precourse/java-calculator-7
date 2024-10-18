package calculator.validator;

import calculator.global.exception.ErrorMessage;

public class StringValidator {

    public static void isEmpty(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT_ERROR.getMessage());
        }
    }
}
