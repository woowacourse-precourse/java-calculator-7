package calculator.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DelimiterParser {
    private static final String[] DEFAULT_DELIMITERS = new String[]{",", ":"};
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private String input;
    private final Set<String> delimiters;

    public DelimiterParser(String input) {
        this.input = input;
        this.delimiters = new HashSet<>();
        parseDelimiters(input);
    }

    public Set<String> getDelimiters() {
        return delimiters;
    }

    public String getInput() {
        return input;
    }

    private void parseDelimiters(final String input) {
        if (containsDefaultDelimiters(input)) {
            defaultDelimiters();
        } else {
            findCustomDelimiters(input);
        }
    }

    private boolean containsDefaultDelimiters(final String input) {
        for (String delimiter : DEFAULT_DELIMITERS) {
            if (input.contains(delimiter)) {
                return true;
            }
        }
        return false;
    }

    private void defaultDelimiters() {
        delimiters.addAll(Arrays.asList(DEFAULT_DELIMITERS));
    }

    private void findCustomDelimiters(final String input) {
        final int delimiterStart = input.indexOf(CUSTOM_DELIMITER_PREFIX);
        final int delimiterEnd = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        validateCustomDelimiterPostion(delimiterStart, delimiterEnd);
        String customDelimiter = input.substring(delimiterStart + 2, delimiterEnd);
        delimiters.add(customDelimiter);
        updateInputString(delimiterEnd);
    }

    private void validateCustomDelimiterPostion(final int delimiterStart, final int delimiterEnd) {
        if (delimiterEnd == -1 || delimiterStart == -1) {
            throw new IllegalArgumentException("커스텀 구분자는 //와 \\n 사이에 위치하여야 합니다.");
        }
    }

    private void updateInputString(final int delimiterEnd) {
        this.input = input.substring(delimiterEnd + 2);
    }
}
