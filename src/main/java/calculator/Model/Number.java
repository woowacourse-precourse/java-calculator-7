package calculator.Model;

import calculator.Constants.ErrorMessages;

public class Number {
    private final int number;

    public Number(String number) {
        this.number = parseAndValidate(number);
    }

    public Integer getNumber() {
        return number;
    }

    private int parseAndValidate(String number) {
        if (isNull(number)) {
            return 0;
        } else {
            int parsedNumber = Integer.parseInt(number);
            isDigit(number);
            isPositive(parsedNumber);
            return parsedNumber;
        }
    }

    private void isPositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_RANGE_MESSAGE.getErrorMessage());
        }
    }

    private void isDigit(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_MESSAGE.getErrorMessage());
        }
    }

    private boolean isNull(String number) {
        return number.isEmpty() || number.isBlank();
    }
}
