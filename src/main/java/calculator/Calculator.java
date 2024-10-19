package calculator;

import java.util.List;

public class Calculator {
    public static long calculate(final String input) {
        if (input.isEmpty()) return 0;

        List<String> parsedNumbers = Parser.parseNumbers(input);

        return parsedNumbers.stream()
                .mapToLong(Validator::validate)
                .reduce(0, Calculator::safeAdd);
    }

    private static long safeAdd(final long sumSoFar, final long num) {
        if (sumSoFar > Long.MAX_VALUE - num) throw new IllegalArgumentException("[ERROR] 숫자의 합이 범위를 초과하였습니다.");
        return sumSoFar + num;
    }
}