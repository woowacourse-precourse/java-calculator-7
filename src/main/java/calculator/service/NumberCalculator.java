package calculator.service;

import calculator.domain.Numbers;

public class NumberCalculator {

    public Numbers calculateNumbers(String numberPart, String splitForm) {
        String[] split = numberPart.trim().split(splitForm);

        Numbers numbers = new Numbers();
        for (String temp : split) {
            int number = toInt(temp);
            validateNumber(number);
            numbers.add(number);
        }
        return numbers;
    }

    private int toInt(String temp) {
        try {
            return Integer.parseInt(temp);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }
}
