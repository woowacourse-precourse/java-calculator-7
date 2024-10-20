package calculator.model.delimiter;

import static calculator.model.delimiter.DefaultDelimiter.DEFAULT_DELIMITERS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class CustomDelimiter implements Delimiter {
    public static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private final Set<String> delimiters;

    protected CustomDelimiter(final String input) {
        this.delimiters = initDelimiters(input);
    }

    private Set<String> initDelimiters(final String input) {
        Set<String> delimiters = new HashSet<>(Arrays.asList(DEFAULT_DELIMITERS));
        delimiters.add(findCustomDelimiter(input));
        return delimiters;
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

    private String escapeMetaCharacter(final String delimiter) {
        return Pattern.quote(delimiter);
    }

    @Override
    public Set<String> getDelimiters() {
        return delimiters;
    }
}
