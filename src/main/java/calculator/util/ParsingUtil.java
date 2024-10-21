package calculator.util;

import calculator.exception.CalculatorError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ParsingUtil {
    private static final String DEFAULT_DELIMITER_1 = ",";
    private static final String DEFAULT_DELIMITER_2 = ":";
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_START_REGEX = "//";
    private static final String CUSTOM_DELIMITER_END_REGEX = "\\\\n";

    private ParsingUtil() {
    }

    public static List<String> extractNumbers(String input) {
        checkNullOrEmpty(input);

        if (containsCustomDelimiter(input)) {
            return parseWithCustomDelimiter(input);
        }
        return parseWithDefault(input);
    }

    public static List<String> parseWithDefault(String input) {
        checkNullOrEmpty(input);

        return Arrays.asList(input.split(DEFAULT_DELIMITER_REGEX));
    }

    public static List<String> parseWithCustomDelimiter(String input) {
        checkNullOrEmpty(input);

        List<String> delimiters = extractCustomDelimiter(input);
        String[] split = input.split(CUSTOM_DELIMITER_END_REGEX);
        String numbers = split[split.length - 1];

        for (String delimiter : delimiters) {
            numbers = numbers.replace(delimiter, DEFAULT_DELIMITER_1);
        }

        return parseWithDefault(numbers);
    }


    public static List<String> extractCustomDelimiter(String input) {
        checkNullOrEmpty(input);
        var splitInput = input.split(CUSTOM_DELIMITER_END_REGEX);
        List<String> delimiters = new ArrayList<>();
        for (int index = 0; index < splitInput.length - 1; index++) {
            var customDelimiter = splitInput[index].replace(CUSTOM_DELIMITER_START_REGEX, "");
            customDelimiter = customDelimiter.trim();
            checkDelimiter(customDelimiter);
            delimiters.add(customDelimiter);
        }
        return delimiters;
    }

    public static boolean containsCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_START_REGEX);
    }

    public static void checkDelimiter(String delimiter) {
        checkDelimiterFormat(delimiter);
        checkDelimiterEmpty(delimiter);
    }

    public static void checkDelimiterFormat(String delimiter) {
        if (delimiter.matches("\\d+")) {
            throw new IllegalArgumentException(CalculatorError.DELIMITER_IS_NUMBER.getMessage());
        }
    }

    public static void checkDelimiterEmpty(String delimiter) {
        if (delimiter == null || delimiter.isEmpty() || delimiter.isBlank()) {
            throw new IllegalArgumentException(CalculatorError.DELIMITER_IS_EMPTY.getMessage());
        }
    }

    private static void checkNullOrEmpty(String input) {
        if (input == null || input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(CalculatorError.INPUT_IS_NULL_OR_EMPTY.getMessage());
        }
    }
}