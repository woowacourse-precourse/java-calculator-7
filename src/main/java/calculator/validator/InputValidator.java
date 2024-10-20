package calculator.validator;

import calculator.enums.ErrorMessage;
import calculator.enums.RegexPattern;

public class InputValidator {

    private InputValidator() {
    }

    public static void validate(String input) {
        validateBlank(input);
        validateIsStartBlank(input);
        validateIsEndBlank(input);
    }

    private static void validateBlank(String input) {
        if (!input.isEmpty() && input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT_NOT_ALLOWED.getMessage());
        }
    }

    private static void validateIsStartBlank(String input) {
        if (RegexPattern.BLANK_IN_START.matches(input)) {
            throw new IllegalArgumentException(ErrorMessage.FIRST_CHAR_CANNOT_BE_SPACE.getMessage());
        }
    }

    private static void validateIsEndBlank(String input) {
        if (RegexPattern.BLANK_IN_END.matches(input)) {
            throw new IllegalArgumentException(ErrorMessage.LAST_CHAR_CANNOT_BE_SPACE.getMessage());
        }
    }
}
