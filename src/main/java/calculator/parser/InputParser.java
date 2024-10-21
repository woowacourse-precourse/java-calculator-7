package calculator.parser;

import calculator.parser.util.CustomDelimiterParser;
import calculator.parser.util.StringToIntegerListConverter;
import java.util.List;

public class InputParser {
    private static final String DEFAULT_DELIMITER = ",:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    private final CustomDelimiterParser customDelimiterParser;
    private final StringToIntegerListConverter stringToIntegerListConverter;

    public InputParser() {
        this.customDelimiterParser = new CustomDelimiterParser(CUSTOM_DELIMITER_PREFIX, CUSTOM_DELIMITER_SUFFIX);
        this.stringToIntegerListConverter = new StringToIntegerListConverter();
    }

    public List<Integer> parse(String input) {
        if (input == null || input.isEmpty()) {
            return List.of();
        }

        Character customDelimiter = customDelimiterParser.getDelimiter(input);
        return stringToIntegerListConverter.convert(split(input, customDelimiter));
    }

    private List<String> split(String input, Character customDelimiter) {
        String delimiters = DEFAULT_DELIMITER;
        if (customDelimiter != null) {
            delimiters += customDelimiter;
        }

        input = removeCustomDelimiterInfo(input);
        return List.of(input.split("[" + delimiters + "]"));
    }

    private String removeCustomDelimiterInfo(String input) {
        int startIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        if (startIndex == -1) {
            return input;
        }

        int endIndex = startIndex + CUSTOM_DELIMITER_SUFFIX.length();
        return input.substring(endIndex);
    }
}
