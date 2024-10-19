package calculator.vaildator;

import calculator.Message.ErrorMessage;

public class InputValidator {

    public void validateInputArray(String[] inputArr) {
        for (String num : inputArr) {
            if (num.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
            }

            if (num.matches("0+")) {
                throw new IllegalArgumentException(ErrorMessage.ZERO_NOT_ALLOWED.getMessage());
            }

            if (num.contains("-")) {
                throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_NOT_ALLOWED.getMessage());
            }

            if (!num.matches("[0-9]+")) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_CHARACTER.getMessage());
            }

            try {
                if (Integer.parseInt(num) > Integer.MAX_VALUE - 1) {
                    throw new IllegalArgumentException(ErrorMessage.NUMBER_TOO_LARGE.getMessage());
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
            }
        }
    }
}
