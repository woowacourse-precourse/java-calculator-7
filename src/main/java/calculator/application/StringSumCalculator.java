package calculator.application;

import calculator.common.ErrorMessage;
import java.util.Arrays;

public class StringSumCalculator {

    public int sumStringNumbers(String[] stringNumbers) {
        return Arrays.stream(stringNumbers)
                .mapToInt(this::parseAndValidate)
                .sum();
    }

    private int parseAndValidate(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        validatePositiveNumber(number);
        return number;
    }

    private void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NON_POSITIVE_NUMBER_ERROR);
        }
    }
}
