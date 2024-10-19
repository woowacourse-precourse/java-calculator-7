package calculator.domain;

import calculator.common.exception.InvalidNumberFormatException;
import calculator.common.exception.NegativeNumberException;

public class Number {

    private final int value;

    public Number(String token) {
        this.value = parseAndValidate(token);
    }

    private int parseAndValidate(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new NegativeNumberException(token);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException(token);
        }
    }

    public int getValue() {
        return value;
    }
}
