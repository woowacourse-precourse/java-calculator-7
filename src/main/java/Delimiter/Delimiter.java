package Delimiter;

import exception.ErrorMessage;

public class Delimiter {
    protected static void checkIsEmpty(String token) {
        if (token.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_IS_EMPTY.toString());
        }
    }

    protected static int isPositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_IS_POSITIVE.toString());
        }
        return number;
    }
}
