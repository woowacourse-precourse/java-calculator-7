package calculator.parser;

import static calculator.parser.PositiveNumberExceptionMessage.NO_EMPTY;
import static calculator.parser.PositiveNumberExceptionMessage.NO_NEGATIVE;

public class PositiveNumber {
    private static final int ZERO = 0;
    private final int number;


    public PositiveNumber(Integer number) {
        validateEmpty(number);
        validatePositive(number);
        this.number = number;
    }

    public int getValue() {
        return this.number;
    }

    private void validateEmpty(Integer number) {
        if (isEmpty(number)) {
            throw new IllegalArgumentException(NO_EMPTY.getMessage());
        }
    }

    private void validatePositive(Integer number) {
        if (!isPositive(number)) {
            throw new IllegalArgumentException(NO_NEGATIVE.getMessage());
        }
    }

    private boolean isPositive(Integer number) {
        return number >= ZERO;
    }

    private boolean isEmpty(Integer number) {
        return number == null || number.equals("");
    }


}
