package calculator.service;

import static calculator.util.Const.NEGATIVE_NUMBER_ERROR_MESSAGE;
import static calculator.util.Const.NUMBER_FORMAT_ERROR_MESSAGE;
import static calculator.util.Const.ZERO;

import calculator.domain.Numbers;

public class NumberCalculator {

    public Numbers calculateNumbers(String numberPart, String splitForm) {
        String[] split = numberPart.trim().split(splitForm);
        Numbers numbers = new Numbers();
        for (String target : split) {
            int number = toInt(target);
            validateNumber(number);
            numbers.add(number);
        }
        return numbers;
    }

    private int toInt(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private void validateNumber(int number) {
        if (number < ZERO) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }
}
