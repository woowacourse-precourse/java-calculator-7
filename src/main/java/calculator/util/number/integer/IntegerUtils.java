package calculator.util.number.integer;

import calculator.common.exception.ExceptionFactory;

import java.util.List;

import static calculator.common.exception.ExceptionType.*;

public final class IntegerUtils {

    private IntegerUtils() {
        throw ExceptionFactory.createException(CAN_NOT_INSTANTIATE);
    }

    public static int sum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, IntegerUtils::addWithOverflowCheck);
    }

    public static List<Integer> parseIntegers(List<String> values) {
        try {
            return values.stream().map(value -> value.isEmpty() ? 0 : Integer.parseInt(value)).toList();
        } catch (NumberFormatException e) {
            throw ExceptionFactory.createException(PARSE_INTEGER_FAILED);
        }
    }

    private static int addWithOverflowCheck(int a, int b) {
        int result = a + b;
        if (isPositiveOverflow(a, b, result) || isNegativeOverflow(a, b, result)) {
            throw ExceptionFactory.createException(SUM_INTEGER_OVERFLOW);
        }
        return result;
    }

    private static boolean isPositiveOverflow(int a, int b, int result) {
        return a > 0 && b > 0 && result < 0;
    }

    private static boolean isNegativeOverflow(int a, int b, int result) {
        return a < 0 && b < 0 && result > 0;
    }
}
