package calculator.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DelimiterParser {
    private static final String[] DEFAULT_DELIMITERS = new String[]{",", ":"};
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final int DEFAULT_DELIMITER_END = -2;
    private final Set<String> delimiters;
    private final int delimiterEnd;

    protected DelimiterParser(final String input) {
        this.delimiterEnd = initDelimiterEnd(input);
        this.delimiters = parseDelimiters(input);
    }

    protected Set<String> getDelimiters() {
        return delimiters;
    }

    protected int getDelimiterEnd() {
        return delimiterEnd;
    }

    private Set<String> parseDelimiters(final String input) {
        if (containsDefaultDelimiters(input)) {
            return defaultDelimiters();
        }
        return findCustomDelimiters(input);
    }

    private boolean containsDefaultDelimiters(final String input) {
        for (String delimiter : DEFAULT_DELIMITERS) {
            if (input.contains(delimiter)) {
                return true;
            }
        }
        return false;
    }

    private int initDelimiterEnd(final String input) {
        if (containsDefaultDelimiters(input)) {
            return DEFAULT_DELIMITER_END;
        }
        return input.indexOf(CUSTOM_DELIMITER_SUFFIX);
    }

    private Set<String> defaultDelimiters() {
        return new HashSet<>(Arrays.asList(DEFAULT_DELIMITERS));
    }

    private Set<String> findCustomDelimiters(final String input) {
        final Set<String> customDelimiter = new HashSet<>();
        final int delimiterStart = input.indexOf(CUSTOM_DELIMITER_PREFIX);
        validateCustomDelimiterPostion(delimiterStart);
        customDelimiter.add(input.substring(delimiterStart + 2, delimiterEnd));
        return customDelimiter;
    }

    private void validateCustomDelimiterPostion(final int delimiterStart) {
        if (delimiterEnd == -1 || delimiterStart == -1) {
            throw new IllegalArgumentException("커스텀 구분자는 //와 \\n 사이에 위치하여야 합니다.");
        }
    }
}
