package calculator;

import calculator.exception.InvalidDelimiterException;

import java.util.Arrays;
import java.util.List;

public class CalculatorInputParser {
    private final static String CUSTOM_DELIMITER_PREFIX = "//";
    private final static String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private final static String DEFAULT_DELIMITERS = ",:";

    private int findCustomDelimiterBounds(String input) {
        final int start = input.indexOf(CUSTOM_DELIMITER_PREFIX);
        final int end = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

        if (start == -1 && end == -1) {
            return -1;
        }

        return end;
    }

    private String extractCustomDelimiter(String input) {
        final int end = findCustomDelimiterBounds(input);
        if (end == -1) {
            return "";
        }
        return input.substring(CUSTOM_DELIMITER_PREFIX.length(), end);
    }

    private List<Integer> parseNumbers(String input, String regex) {
        try {
            return Arrays.stream(input.split(regex))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new InvalidDelimiterException();
        }
    }

    public List<Integer> parse(String input) {
        final String customDelimiter = extractCustomDelimiter(input);
        final String regex = "[" + DEFAULT_DELIMITERS + customDelimiter + "]";

        final StringBuffer numberStr = new StringBuffer(input);
        if (!customDelimiter.isEmpty()) {
            final int end = findCustomDelimiterBounds(input);
            numberStr.delete(0, end + CUSTOM_DELIMITER_SUFFIX.length());
        }

        return parseNumbers(numberStr.toString(), regex);
    }
}
