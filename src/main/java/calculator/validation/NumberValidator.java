package calculator.validation;

public class NumberValidator {

    private static final String INVALID_INPUT_ERROR = "잘못된 입력값입니다.";

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
