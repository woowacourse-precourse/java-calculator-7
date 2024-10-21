package util;

import exception.ErrorMessage;

public class Validator {

    public static void isEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_IS_EMPTY_STRING.toString());
        }
    }
}
