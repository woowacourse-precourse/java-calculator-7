package calculator.domain.validation;

import calculator.exception.ErrorMessage;

public class NumberInputValidator {

    public static int validateOnlyNumeric(String value) {
        if (isNotNumeric(value)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_CUSTOMIZED.getMessage());
        }

        return Integer.parseInt(value);
    }

    private static boolean isNotNumeric(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}