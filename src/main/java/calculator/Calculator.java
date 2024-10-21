package calculator;

import java.util.Arrays;

public class Calculator {
    private static final int ZERO = 0;
    private static final String DELIMITER = ",|:";

    public static int calculate(String input) {
        if (isBlank(input)) {
            return ZERO;
        }
        return sum(input.split(DELIMITER));
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private static int sum(String[] values) {
        return Arrays.stream(values)
                .mapToInt(Calculator::toInt)
                .sum();
    }

    private static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
