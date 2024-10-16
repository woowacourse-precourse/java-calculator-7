package calculator.Model;

import calculator.Constants.ErrorMessages;

public class Number {
    private final int number;

    public Number(String number) {
        validateNumber(Integer.parseInt(number));
        this.number = Integer.parseInt(number);
    }

    public Integer getNumber() {
        return number;
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
