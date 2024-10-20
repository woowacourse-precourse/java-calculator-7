package calculator;

import java.util.HashSet;
import java.util.Set;

public class DelimiterFactory {

    private static final Set<Character> BASE_DELIMITERS = Set.of(',', ':');
    private static final String DELIMITER_PREFIX = "//";
    private static final String DELIMITER_SUFFIX = "\\n";
    private static final int DELIMITER_PREFIX_LENGTH = DELIMITER_PREFIX.length();

    public Set<Character> getBaseDelimiters() {
        return BASE_DELIMITERS;
    }

    public int findFirstIndexAfterDelimiters(String input) {
        int index = 0;
        while (input.startsWith(DELIMITER_PREFIX, index)) {
            int newlineIndex = input.indexOf(DELIMITER_SUFFIX, index);
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("Invalid input format. Missing '\\n'.");
            }
            index = newlineIndex + DELIMITER_SUFFIX.length();
        }
        return index;
    }

    public Set<Character> createDelimiters(String input) {
        Set<Character> delimiters = new HashSet<>(BASE_DELIMITERS);
        int index = 0;

        while (input.startsWith(DELIMITER_PREFIX, index)) {
            int newlineIndex = input.indexOf(DELIMITER_SUFFIX, index);
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("Invalid input format. Missing '\\n'.");
            }

            String delimiterPart = input.substring(index + DELIMITER_PREFIX_LENGTH, newlineIndex);
            if (delimiterPart.length() != 1) {
                throw new IllegalArgumentException("Invalid custom delimiter length. Only one character is allowed.");
            }

            delimiters.add(delimiterPart.charAt(0));
            index = newlineIndex + DELIMITER_SUFFIX.length();
        }

        return delimiters;
    }
}
