package calculator;

import calculator.exception.CalculatorParsedException;

public class CustomDelimiterValidator {
    private static final int MAX_LENGTH = 1;

    public static void validate(String customDelimiter) {
        if (customDelimiter.isEmpty()) {
            throw new CalculatorParsedException(CalculatorParsedException.CUSTOM_NOT_EMPTY);
        }
        if (customDelimiter.length() > MAX_LENGTH) {
            throw new CalculatorParsedException(
                    String.format(CalculatorParsedException.CUSTOM_OVER_LENGTH, MAX_LENGTH));
        }
        if (Character.isDigit(customDelimiter.charAt(0))) {
            throw new CalculatorParsedException(CalculatorParsedException.CUSTOM_NOT_NUMERIC);
        }
    }
}

