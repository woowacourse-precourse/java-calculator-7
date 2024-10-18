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

    public long sum() {
        return Arrays.stream(splitInputs)
                .mapToLong(this::parsedNumber)
                .filter(this::validatePositiveNumber)
                .sum();
    }

    private long parsedNumber(String number) {
        try {
            return Long.parseLong(number);
        } catch (NumberFormatException e) {
            throw new CalculatorException(INVALID_INPUT_VALUE.getMessage());
        }
    }

    private boolean validatePositiveNumber(long number) {
        if (number <= 0) {
            throw new CalculatorException(NEGATIVE_VALUE_NOT_ALLOWED.getMessage());
        }
        return true;
    }
}
