package calculator.util;

import calculator.exception.CalculatorError;
import java.util.Arrays;
import java.util.List;

public final class ParsingUtil {
    private static final String DEFAULT_DELIMITER = ",|:";

    private ParsingUtil() {
    }

    public static List<String> parseWithDefault(String input) {
        if (isInputNull(input)) {
            throw new IllegalArgumentException(CalculatorError.INPUT_IS_NULL_OR_EMPTY.getMessage());
        }

        return Arrays.asList(input.split(DEFAULT_DELIMITER));
    }

    private static boolean isInputNull(String input) {
        return input == null || input.isEmpty();
    }
}