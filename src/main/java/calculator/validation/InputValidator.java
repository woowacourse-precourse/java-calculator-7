package calculator.validation;

import calculator.enums.ErrorMessage;

public class InputValidator {

    public InputValidator() {
    }

    public static void validateStartBlank(String input) {
        if (input != null && input.startsWith(" ")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_BLANK.getMessage());
        }
    }
}
