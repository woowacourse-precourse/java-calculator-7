package calculator.domain.value;

import calculator.error.ErrorMessage;

public class Number {
    private static final int ZERO = 0;

    private final int value;

    public Number(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(String value) {
        int num;
        try {
            num = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }

        if (num < ZERO) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_NOT_ALLOWED);
        }
    }

    public int getValue() {
        return value;
    }
}