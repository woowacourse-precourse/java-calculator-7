package calculator.domain.calculator.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Delimiter {
    private static final String DEFAULT_PATTERN = "[,:]";
    private final String pattern;

    private Delimiter(String pattern) {
        this.pattern = validateAndParseDelimiter(pattern);
    }

    public static Delimiter of(final String input) {
        return new Delimiter(input);
    }

    private String validateAndParseDelimiter(final String input) {
        if (input.isEmpty()) {
            return DEFAULT_PATTERN;
        }

        if (!input.startsWith("//")) {
            return DEFAULT_PATTERN;
        }

        int newLineIndex = input.indexOf("\\n");
        if (newLineIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자를 닫는 문자가 없습니다.");
        }

        final String customDelimiterPart = input.substring(2, newLineIndex);

        System.out.println(buildPattern(customDelimiterPart));
        return buildPattern(customDelimiterPart);
    }

    private String escapeSpecialCharacters(final String delimiter) {
        return delimiter.replaceAll("([\\[\\](){}.*+?^$|\\\\])", "\\\\$1");
    }

    private String buildPattern(final String customDelimiterPart) {
        if (customDelimiterPart.isEmpty()) {
            return DEFAULT_PATTERN;
        }

        final String escapedDelimiters = Arrays.stream(customDelimiterPart.split("\\|"))
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining("|"));

        return DEFAULT_PATTERN + "|" + escapedDelimiters;
    }

    public String getPattern() {
        return this.pattern;
    }
}