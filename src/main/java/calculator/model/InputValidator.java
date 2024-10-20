package calculator.model;

import static calculator.exception.ExceptionMessage.INPUT_IS_INVALID;

public class InputValidator {

    public static InputValidator getInstance() {
        return new InputValidator();
    }

    private InputValidator() {
    }

    public void validate(String input) {
        if (!(DefaultDelimiter.hasDefaultDelimiter(input) || CustomDelimiter.getInstance()
                .hasCustomDelimiter(input))) {
            throw new IllegalArgumentException(INPUT_IS_INVALID);
        }
    }
}
