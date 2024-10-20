package calculator.domain;

import static calculator.exception.constants.ErrorMessage.INVALID_INPUT_VALUE;
import static calculator.exception.constants.ErrorMessage.NEGATIVE_VALUE_NOT_ALLOWED;

import calculator.exception.CalculatorException;
import java.util.Arrays;

public class Calculator {

    private final String[] splitInputs;

    public Calculator(String[] splitInputs) {
        this.splitInputs = splitInputs;
    }

    public Number sum() {
        if (this.splitInputs.length == 0) {
            return 0L;
        }

        double result = Arrays.stream(this.splitInputs)
                .mapToDouble(this::parsedNumber)
                .filter(this::validatePositiveNumber)
                .sum();

        if (isNaturalNumber(result)) {
            return (long) result;
        }
        return result;
    }

    private double parsedNumber(String number) {
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new CalculatorException(INVALID_INPUT_VALUE.getMessage());
        }
    }

    private boolean validatePositiveNumber(double number) {
        if (number <= 0) {
            throw new CalculatorException(NEGATIVE_VALUE_NOT_ALLOWED.getMessage());
        }
        return true;
    }

    private boolean isNaturalNumber(double number) {
        return Math.floor(number) == number;
    }
}
