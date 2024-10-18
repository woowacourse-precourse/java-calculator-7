package calculator;

import calculator.exception.InvalidDelimiterException;

import java.util.Arrays;
import java.util.List;

public class CalculatorInputParser {
    private final static String CUSTOM_DELIMITER_PREFIX = "//";
    private final static String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private final static String DEFAULT_DELIMITERS = ",:";

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
        final String regex = "[" + DEFAULT_DELIMITERS + "]";
        return parseNumbers(input, regex);
    }
}
