package calculator.validation;

import static calculator.global.constant.ExceptionConstants.INVALID_INPUT_ERROR;

public class NumberValidator {

    public void validateNumbers(String[] values) {
        for (String value : values) {
            validateIsPositiveNumber(value);
        }
    }

    private void validateIsPositiveNumber(String value) {
        if (value.isEmpty() || !isInteger(value) || !isPositive(value)) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    private boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isPositive(String number) {
        if (Integer.parseInt(number) > 0) {
            return true;
        }
        return false;
    }
}
