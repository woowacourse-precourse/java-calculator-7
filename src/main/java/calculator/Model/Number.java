package calculator.Model;

import calculator.Constants.ErrorMessages;

public class Number {
    private final int number;

    public Number(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        isPositive(number);
    }

    private void isPositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_RANGE_MESSAGE.getErrorMessage());
        }
    }

}
