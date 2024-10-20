package calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private static final List<String> DEFAULT_SEPARATORS = List.of(",", ":");

    public static int add(String target) {
        if (target.isBlank()) {
            throw new IllegalArgumentException("input string is blank");
        }

        // 커스텀 구분자를 사용하는 경우
        if (target.startsWith("//")) {
            return calcWithCustomSeparator(target);
        }

        List<Integer> numbers = parseIntegers(target, DEFAULT_SEPARATORS);
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static Integer calcWithCustomSeparator(String target) {
        int idx1 = target.indexOf("//");
        int idx2 = target.indexOf("\\n");

        if (idx1 > idx2) {
            throw new IllegalArgumentException("invalid format to use custom separator");
        }

        List<String> customSeparators = List.of(target.substring(idx1 + 2, idx2));
        target = target.substring(idx2 + 2);

        List<Integer> numbers = parseIntegers(target, customSeparators);
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static List<Integer> parseIntegers(String target, List<String> separator) {
        try {
            List<Integer> parsed = Arrays.stream(target.split(String.join("|", separator)))
                    .map(Integer::parseInt)
                    .toList();
            parsed.forEach(Calculator::checkPositiveInteger);
            return parsed;
        } catch (Exception e) {
            throw new IllegalArgumentException("enter only integers between separator");
        }
    }

    public static void checkPositiveInteger(Integer i) {
        if (i < 0) {
            throw new IllegalArgumentException("enter only positive integers between separator");
        }
    }
}
