package calculator.model;

import static calculator.model.enums.ExceptionMessage.NUMERIC_EXCEPTION;
import static calculator.model.enums.ExceptionMessage.RANGE_EXCEPTION;
import static calculator.util.Converter.convertToInteger;

public class Number {
    private final int number;

    private static final int NUMBER_RANGE_CONDITION = 1;

    public Number(String number) {
        validate(number);
        this.number = convertToInteger(number);
    }

    public int getNumber() {
        return number;
    }

    private void validate(String number) {
        validateNumeric(number);
        validateRange(number);
    }

    private void validateNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_EXCEPTION.getMessage());
        }
    }

    private void validateRange(String number) {
        if (Integer.parseInt(number) < NUMBER_RANGE_CONDITION) {
            throw new IllegalArgumentException(RANGE_EXCEPTION.getMessage());
        }
    }
}
