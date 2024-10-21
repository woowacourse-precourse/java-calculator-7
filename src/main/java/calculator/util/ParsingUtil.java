package calculator.util;

import calculator.exception.CalculatorError;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ParsingUtil {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//\\s*(.)\\s*\\n";

    private ParsingUtil() {
    }

    public static boolean containsCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);
        Matcher matcher = pattern.matcher(input);

        return matcher.find();
    }

    public static List<String> parseWithDefault(String input) {
        if (isInputIsNullOrEmpty(input)) {
            throw new IllegalArgumentException(CalculatorError.INPUT_IS_NULL_OR_EMPTY.getMessage());
        }

        return Arrays.asList(input.split(DEFAULT_DELIMITER));
    }

    private static boolean isInputIsNullOrEmpty(String input) {
        return input == null || input.isEmpty() || input.isBlank();
    }
}