package calculator.util;

import calculator.enums.ErrorMessage;
import calculator.enums.RegexPattern;
import java.util.HashSet;
import java.util.Set;

public class DelimiterExtractor {
    public static final String DELIMITER_PREFIX = "//";
    public static final String DELIMITER_SUFFIX = "\\n";


    private DelimiterExtractor() {
    }

    public static Set<String> parse(String input) {
        Set<String> delimiters = new HashSet<>();

        int currentIndex = 0;

        while (findPrefixIndex(input, currentIndex) != -1) {
            int suffixIndex = findSuffixIndex(input, currentIndex);
            if (suffixIndex == -1) {
                throw new IllegalArgumentException(ErrorMessage.DELIMITER_SUFFIX_NOT_FOUND.getMessage());
            }

            String delimiter = extractDelimiter(input, currentIndex, suffixIndex);
            validateDelimiter(delimiter);
            delimiters.add(delimiter);

            currentIndex = suffixIndex + DELIMITER_SUFFIX.length();
        }

        return delimiters;
    }

    private static void validateDelimiter(String delimiter) {
        validateNotEmpty(delimiter);
        validateNotNumeric(delimiter);
    }

    private static void validateNotEmpty(String delimiter) {
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_NOT_FOUND.getMessage());
        }
    }

    private static void validateNotNumeric(String delimiter) {
        if (RegexPattern.CONTAINS_NUMERIC.matches(delimiter)) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_CANNOT_CONTAIN_NUMERIC.getMessage());
        }
    }

    private static int findPrefixIndex(String input, int currentIndex) {
        return input.indexOf(DELIMITER_PREFIX, currentIndex);
    }

    private static int findSuffixIndex(String input, int startIndex) {
        return input.indexOf(DELIMITER_SUFFIX, startIndex + DELIMITER_PREFIX.length());
    }

    private static String extractDelimiter(String input, int startIndex, int endIndex) {
        return input.substring(startIndex + DELIMITER_PREFIX.length(), endIndex);
    }
}
