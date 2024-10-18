package calculator.util;

import static calculator.constant.ErrorMessage.INVALID_INPUT;
import static calculator.constant.ErrorMessage.REQUIRED_POSITIVE_NUMBER;

public class ValidationUtil {
    public void isValidInput(String initialInput) {
        if (!initialInput.startsWith("//") && !Character.isDigit(initialInput.charAt(0))) {
            throw new IllegalArgumentException(REQUIRED_POSITIVE_NUMBER.getMessage());
        }
    }

    public void isValidNumber(String s) {
        if (!Character.isDigit(s.charAt(0))) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }

    }

}
