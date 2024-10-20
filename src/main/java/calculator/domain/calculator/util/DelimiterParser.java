package calculator.domain.calculator.util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DelimiterParser {
    private static final String DEFAULT_PATTERN = ",|:";


    public static String parse(String input) {
        if (input == null || input.isEmpty() || !input.startsWith("//")) {
            return DEFAULT_PATTERN;
        }

        final int newLineIndex = input.indexOf("\\n");
        if (newLineIndex == -1) {
            // CUSTOM_DELIMITER_CLOSING_CHAR_MISSING.getMessage()
            throw new IllegalArgumentException();
        }

        final String customDelimiterPart = input.substring(2, newLineIndex);
        return buildPattern(customDelimiterPart);
    }

    private static String buildPattern(String customDelimiterPart) {
        if (customDelimiterPart.isEmpty()) {
            return DEFAULT_PATTERN;
        }

        final String escapedDelimiters = Arrays.stream(customDelimiterPart.split("\\|"))
                .map(DelimiterParser::escapeSpecialCharacters)
                .collect(Collectors.joining("|"));

        return DEFAULT_PATTERN + "|" + escapedDelimiters;
    }

    private static String escapeSpecialCharacters(String input) {
        return input.replaceAll("([\\[\\](){}.*+?^$|\\\\])", "\\\\$1");
    }
}