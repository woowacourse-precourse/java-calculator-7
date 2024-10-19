package calculator.domain;

import static calculator.exception.Exception.INVALID_FORMAT;
import static calculator.exception.Exception.INVALID_NEGATIVE_NUMBER;
import static calculator.exception.Exception.NUMERIC_TOO_LONG;

public class Number {

    private static final int MAX_LENGTH = 10;
    private final long value;

    public Number(String input) {
        validate(input);
        this.value = parseLong(input);
    }

    public long getValue() {
        return value;
    }

    private void validate(String input) {
        validateFormat(input);
        validateLength(input);
        validatePositive(input);
    }

    private long parseLong(String number) {
        try {
            return Long.parseLong(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }

    private void validateFormat(String input) {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }

    private void validateLength(String input) {
        int maxAllowedLength = input.startsWith("-") ? MAX_LENGTH + 1 : MAX_LENGTH;

        if (input.length() > maxAllowedLength) {
            throw new IllegalArgumentException(NUMERIC_TOO_LONG.getMessage());
        }
    }

    private void validatePositive(String input) {
        if (input.startsWith("-")) {
            throw new IllegalArgumentException(INVALID_NEGATIVE_NUMBER.getMessage());
        }
    }
}
