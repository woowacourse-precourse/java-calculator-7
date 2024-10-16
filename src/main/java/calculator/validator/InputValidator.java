package calculator.validator;

import calculator.enums.ErrorMessage;

public class InputValidator {

    private InputValidator() {
    }

    public static void validate(String input) {

    }

    public static void validateBlank(String input) {
        if (!input.isEmpty() && input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT_NOT_ALLOWED.getMessage());
        }
    }
}
