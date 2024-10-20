package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class ExpressionParser {

    private static final int CUSTOM_DELIMITER_LENGTH = 1;
    private static final String REGEX_OR = "|";
    private static final String ESCAPE_CHARACTER = "\\";

    private final String delimiterPattern;

    public ExpressionParser(List<String> delimiters) {
        StringJoiner joiner = new StringJoiner(REGEX_OR);
        for (String delimiter : delimiters) {
            validateDelimiterLength(delimiter);
            joiner.add(escapeDelimiter(delimiter));
        }
        this.delimiterPattern = joiner.toString();
    }

    private void validateDelimiterLength(String delimiter) {
        if (delimiter.length() != CUSTOM_DELIMITER_LENGTH) {
            throw new IllegalArgumentException("구분자는 %d 글자여야 합니다.".formatted(CUSTOM_DELIMITER_LENGTH));
        }
    }

    private String escapeDelimiter(String delimiter) {
        if (delimiter.startsWith(ESCAPE_CHARACTER)) {
            return ESCAPE_CHARACTER + delimiter;
        }
        return delimiter;
    }

    public List<Integer> parse(String expression) {
        return Arrays.stream(expression.split(delimiterPattern))
                .map(this::parseToInteger)
                .toList();
    }

    private int parseToInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: %s".formatted(value));
        }
    }
}
