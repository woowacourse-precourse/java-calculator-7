package calculator.validator;

import calculator.exception.calculator.CalculatorException;

import static calculator.exception.calculator.CalculatorExceptionMessage.MINUS_OR_ZERO_NUMBER;
import static calculator.exception.calculator.CalculatorExceptionMessage.WRONG_INPUT;

public class CalculatorValidator {

    private static final int POSITIVE_START = 1;

    public static void validatePositivity(int num) {
        if (num < POSITIVE_START) {
            throw new CalculatorException(MINUS_OR_ZERO_NUMBER);
        }
    }

    public static void validateNumbers(String numberString) {
        try {
            Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new CalculatorException(WRONG_INPUT);
        }
    }
}
