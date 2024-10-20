package calculator.domain;

import calculator.constant.Condition;

public class Number {
    private final int number;

    public Number(String numberStr) {
        try {
            number = Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (number < Condition.NUMBER_MIN_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    public long add(long sum) {
        return number + sum;
    }
}
