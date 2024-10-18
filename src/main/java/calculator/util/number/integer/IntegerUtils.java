package calculator.util.number.integer;

import java.util.List;

public class IntegerUtils {

    public static int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public static List<Integer> parseIntegers(List<String> values) {
        return values.stream().map(value -> value.isEmpty() ? 0 : Integer.parseInt(value)).toList();
    }
}
