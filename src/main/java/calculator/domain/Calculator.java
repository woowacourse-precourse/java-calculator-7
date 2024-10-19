package calculator.domain;

import static calculator.util.ErrorMessage.*;

import calculator.util.ErrorMessage;
import java.util.List;

public class Calculator {

    private static final int MINIMUM_VALUE = 0;

    public static int sumPositiveNumbers(List<String> digits) {
        if(isEmpty(digits)) return 0;
        return digits.stream()
                .mapToInt(Calculator::parsePositiveInteger)
                .sum();
    }

    private static boolean isEmpty(List<String> digits) {
        return digits.stream().anyMatch(String::isBlank);
    }

    private static int parsePositiveInteger(String s) {
        try {
            int number = Integer.parseInt(s);
            if (number < MINIMUM_VALUE) {
                throw new IllegalArgumentException(INVALID_POSITIVE_NUMBER.getMessage());
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DIGIT.getMessage());
        }
    }
}
