package calculator.model;

import static calculator.model.ExceptionMessage.NUMERIC_EXCEPTION;
import static calculator.model.ExceptionMessage.RANGE_EXCEPTION;

public class Number {
    private final int number;

    private static final int NUMBER_RANGE_CONDITION = 1;

    public Number(String number) {
        validate(number);
        this.number = convertToInteger(number);
    }

    public int convertToInteger(String number) {

        return Integer.parseInt(number);
    }

    public int getNumber() {
        return number;
    }


    public void validate(String number) {
        validateNumeric(number);
        validateRange(number);
    }

    public void validateNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_EXCEPTION.getMessage());
        }
    }

    public void validateRange(String number) {
        if (Integer.parseInt(number) < NUMBER_RANGE_CONDITION) {
            throw new IllegalArgumentException(RANGE_EXCEPTION.getMessage());
        }
    }
}
