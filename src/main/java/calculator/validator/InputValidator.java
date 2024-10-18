package calculator.validator;

import calculator.constants.ErrorMessage;

public class InputValidator {
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
            if (element.equals("0")) {
                throw new IllegalArgumentException(ErrorMessage.ONLY_ALLOWED_POSITIVE_NUMBER);
            }
        }
    }
}
