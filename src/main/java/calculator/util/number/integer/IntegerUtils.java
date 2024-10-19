package calculator.util.number.integer;

import calculator.common.exception.ExceptionFactory;

import java.util.List;

import static calculator.common.exception.ExceptionType.PARSE_INTEGER_FAILED;

public class IntegerUtils {

    public static int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public static List<Integer> parseIntegers(List<String> values) {
        try {
            return values.stream().map(value -> value.isEmpty() ? 0 : Integer.parseInt(value)).toList();
        } catch (NumberFormatException e) {
            throw ExceptionFactory.createException(PARSE_INTEGER_FAILED);
        }
    }
}
