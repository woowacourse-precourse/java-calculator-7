package calculator.model.delimiter;

import java.util.HashSet;
import java.util.Set;

public class CustomDelimiter implements Delimiter {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private final Set<String> delimiters;
    private final int delimiterEnd;

    protected CustomDelimiter(final String input) {
        this.delimiterEnd = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        this.delimiters = findCustomDelimiter(input);
    }

    private Set<String> findCustomDelimiter(final String input) {
        final Set<String> customDelimiter = new HashSet<>();
        final int delimiterStart = input.indexOf(CUSTOM_DELIMITER_PREFIX);
        validateCustomDelimiterPosition(delimiterStart);
        customDelimiter.add(input.substring(delimiterStart + 2, delimiterEnd));
        return customDelimiter;
    }

    private void validateCustomDelimiterPosition(final int delimiterStart) {
        if (delimiterEnd == -1 || delimiterStart == -1) {
            throw new IllegalArgumentException("커스텀 구분자는 //와 \\n 사이에 위치하여야 합니다.");
        }
    }

    @Override
    public Set<String> getDelimiters() {
        return delimiters;
    }

    @Override
    public int getDelimiterEnd() {
        return delimiterEnd;
    }
}
