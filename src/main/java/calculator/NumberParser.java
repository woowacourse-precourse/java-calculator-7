package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class NumberParser {

    private static final String BOUNDARY_SUFFIX = "\\n";
    private static final String PIPE = "|";
    private static final String COMMA = ",";

    private final Delimiter delimiter;

    private NumberParser(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    public static NumberParser from(Delimiter delimiter) {
        return new NumberParser(delimiter);
    }

    public Numbers parse(String value) {
        if (delimiter.hasCustomDelimiter()) {
            value = extractNumberSection(value);
        }
        return Numbers.of(splitAndParseNumbers(value));
    }

    private String extractNumberSection(String value) {
        int suffixStartIndex = value.indexOf(BOUNDARY_SUFFIX);
        return value.substring(suffixStartIndex + BOUNDARY_SUFFIX.length());
    }

    private List<Number> splitAndParseNumbers(String value) {
        String delimiters = buildDelimiterPattern();
        String[] tokens = getValidTokens(value, delimiters);
        return Arrays.stream(tokens)
                .map(Number::from)
                .toList();
    }

    private String buildDelimiterPattern() {
        return delimiter.findAll().stream()
                .map(Pattern::quote)
                .reduce((s1, s2) -> s1 + PIPE + s2)
                .orElse(COMMA);
    }

    private String[] getValidTokens(String value, String delimiters) {
        String[] tokens = value.split(delimiters, -1);
        for (String token : tokens) {
            if (token.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다.");
            }
        }
        return tokens;
    }
}
