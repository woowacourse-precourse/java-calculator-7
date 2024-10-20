package calculator.parser;

import static calculator.parser.PositiveNumberExceptionMessage.NO_EMPTY;
import static calculator.parser.PositiveNumberExceptionMessage.NO_NEGATIVE;

import java.util.List;
import java.util.stream.Collectors;

class PositiveNumberValidator {
    private static final int ZERO = 0;

    public static void validate(List<Integer> numbers) {
        validateEmpty(numbers);
        validateNegative(numbers);
    }

    public static boolean isPositive(int number) {
        return number >= ZERO;
    }

    private static void validateEmpty(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(NO_EMPTY.getMessage());
        }
    }

    private static void validateNegative(List<Integer> numbers) {
        List<Integer> negativeNumbers = numbers.stream()
                .filter(n -> !isPositive(n))
                .collect(Collectors.toList());

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException(NO_NEGATIVE.getMessage() + negativeNumbers);
        }
    }
}