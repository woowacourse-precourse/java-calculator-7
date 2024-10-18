package calculator.domain;

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
            throw new IllegalArgumentException();
        }
    }

    private boolean validatePositiveNumber(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
