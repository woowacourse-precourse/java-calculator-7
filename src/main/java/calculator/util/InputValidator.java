package calculator.util;

import calculator.exception.util.InputValidateErrorMessage;

public class InputValidator {
    public static String validate(String str) {
        if (str == null || str.isEmpty()) {
            return "0";
        }

        if (!str.startsWith("//") && !str.matches("^\\d.*")) {
            throw new IllegalArgumentException(InputValidateErrorMessage.INVALID_INPUT.getMessage());
        }

        return str;
    }
}
