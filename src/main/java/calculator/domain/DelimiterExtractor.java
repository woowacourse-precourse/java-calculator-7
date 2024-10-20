package calculator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DelimiterExtractor {

    private static final List<Character> DEFAULT_DELIMITERS = List.of(',', ':');
    private static final String START_PATTERN = "//";
    private static final String END_PATTERN = "\\n";
    private static final int DELIMITER_IDX = 2;

    public Set<Character> extractDelimiters(String delimiterPart) {
        Set<Character> delimiters = new HashSet<>(DEFAULT_DELIMITERS);

        if (isContainDelimiter(delimiterPart) && isNotEmptyDelimiter(delimiterPart)) {
            delimiters.add(delimiterPart.charAt(DELIMITER_IDX));
        }

        return delimiters;
    }

    public boolean isContainDelimiter(String delimiterPart) {
        return delimiterPart.startsWith(START_PATTERN) && delimiterPart.endsWith(END_PATTERN);
    }

    private boolean isNotEmptyDelimiter(String delimiterPart) {
        return delimiterPart.length() != START_PATTERN.length() + END_PATTERN.length();
    }
}
