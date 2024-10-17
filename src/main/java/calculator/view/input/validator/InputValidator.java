package calculator.view.input.validator;

import calculator.constant.ErrorMessage;
import calculator.separator.domain.RegexPattern;

public class InputValidator {
    public static void validator(String input) {
        isPrefixUseCustomSeparatorValidator(input);
        isMaxValueValidator(input);
    }

    private static void isPrefixUseCustomSeparatorValidator(String input) {
        if (!RegexPattern.isMatch(input)) throw new IllegalArgumentException(ErrorMessage.REGEX_ERROR);
    }
    private static void isMaxValueValidator(String input) {
        try {
            if (input.matches("^[1-9]\\d*$")) Long.parseLong(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MAX_VALUE_ERROR);
        }
    }
}
