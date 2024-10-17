package calculator.util.integer;

import calculator.common.exception.ExceptionFactory;

import java.util.List;

import static calculator.common.exception.ExceptionType.NEGATIVE_NUMBER;

public class IntegerUtils {

    public static int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public static List<Integer> parsePositiveIntegers(List<String> values) {
        return values.stream().map(value -> {
            int number = value.isEmpty() ? 0 : Integer.parseInt(value);
            validatePositiveInteger(number);
            return number;
        }).toList();
    }

    private static void validatePositiveInteger(int number) {
        if (number < 0) {
            throw ExceptionFactory.createException(NEGATIVE_NUMBER);
        }
    }
}
