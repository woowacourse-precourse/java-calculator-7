package calculator.utils;

import calculator.constant.ErrorMessage;

public class ValidateUtils {
    public static void checkNumberIsValid(String number) {
        if (isNumeric(number)) {
            if (Integer.parseInt(number) < 0) {
                throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_INPUT.getMessage());
            }
        } else {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getMessage());
        }
    }

    public static boolean isNumeric(String str) {
        return str != null && str.matches("-?\\d+");
    }
}
