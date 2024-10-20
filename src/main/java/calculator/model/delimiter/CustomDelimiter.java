package calculator.model.delimiter;

import java.util.Collections;
import java.util.Set;
import java.util.regex.Pattern;

public class CustomDelimiter implements Delimiter {
    public static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private final Set<String> delimiters;

    protected CustomDelimiter(final String input) {
        this.delimiters = Collections.singleton(findCustomDelimiter(input));
    }

    private String findCustomDelimiter(final String input) {
        final int delimiterStart = input.indexOf(CUSTOM_DELIMITER_PREFIX);
        final int delimiterEnd = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        validateCustomDelimiterPosition(delimiterStart, delimiterEnd);
        return escapeMetaCharacter(input.substring(delimiterStart + 2, delimiterEnd));
    }

    private void validateCustomDelimiterPosition(final int delimiterStart, final int delimiterEnd) {
        if (delimiterEnd == -1 || delimiterStart == -1) {
            throw new IllegalArgumentException("커스텀 구분자는 //와 \\n 사이에 위치하여야 합니다.");
        }
    }

    private String escapeMetaCharacter(String delimiter) {
        return Pattern.quote(delimiter);
    }

    @Override
    public Set<String> getDelimiters() {
        return delimiters;
    }
}
