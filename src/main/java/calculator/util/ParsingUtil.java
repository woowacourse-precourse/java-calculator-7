package calculator.util;

import calculator.exception.CalculatorError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ParsingUtil {
    private static final String DEFAULT_DELIMITER_1 = ",";
    private static final String DEFAULT_DELIMITER_2 = ":";
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//\\s*(.+)\\s*\\n";

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
        String[] split = input.split("\n");
        String numbers = split[split.length - 1];

        for (String delimiter : delimiters) {
            numbers = numbers.replace(delimiter, DEFAULT_DELIMITER_1);
        }

        return parseWithDefault(numbers);
    }


    public static List<String> extractCustomDelimiter(String input) {
        checkNullOrEmpty(input);

        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(input);
        List<String> delimiters = new ArrayList<>();

        while (matcher.find()) {
            var customDelimiter = matcher.group(1).trim();
            checkDelimiter(customDelimiter);
            delimiters.add(customDelimiter.trim());
        }
        return delimiters;
    }

    public static boolean containsCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(input);

        return matcher.find();
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