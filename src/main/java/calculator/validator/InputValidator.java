package calculator.validator;

import calculator.constants.ErrorMessage;

public class InputValidator {
    private static final String ZERO = "0";
    private static InputValidator instance;

    private InputValidator() {
    }

    public static InputValidator getInstance() {
        if (instance == null) {
            instance = new InputValidator();
        }
        return instance;
    }

    public void validateStrip(String input) {
        String stripped = input.strip();
        if (input.equals(stripped)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_ALLOWED_FIRST_LAST_BLANK);
    }

    public void validateInteger(String[] elements) {
        for (String element : elements) {
            try {
                Integer.parseInt(element);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.ONLY_ALLOWED_INTEGER);
            }
        }
    }

    public void validateZero(String[] separated) {
        for (String element : separated) {
            if (element.equals(ZERO)) {
                throw new IllegalArgumentException(ErrorMessage.ONLY_ALLOWED_POSITIVE_NUMBER);
            }
        }
    }
}
