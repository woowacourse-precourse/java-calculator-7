package calculator.utils;

import calculator.constant.ErrorMessage;

public class Validator {
    public static void checkIsNumberValid(String number) {
        if (!isNumeric(number)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getMessage());
        }
        if (!isPositiveNumber(number)) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_INPUT.getMessage());
        }
    }

    public static boolean isNumeric(String str) {
        return str != null && str.matches("-?\\d+");
    }

    private static boolean isPositiveNumber(String number) {
        return Integer.parseInt(number) > 0;
    }
}
