package calculator.util;

import calculator.enums.ErrorMessage;
import calculator.enums.RegexPattern;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;

public class CustomDelimiterExtractor {

    private CustomDelimiterExtractor() {
    }

    public static Set<String> parse(String input) {
        Set<String> delimiters = new HashSet<>();
        int firstNumberIndex = findFirstNumberIndex(input);

        Matcher customDelimiterMatcher = RegexPattern.CUSTOM_DELIMITER_DECLARATION.matcher(input);

        while (customDelimiterMatcher.find()) {
            validateCustomDelimiterPosition(firstNumberIndex, customDelimiterMatcher.start());

            String delimiter = customDelimiterMatcher.group(1);
            validateDelimiter(delimiter);
            delimiters.add(delimiter);
        }

        return delimiters;
    }

    private static void validateDelimiter(String delimiter) {
        validateNotEmpty(delimiter);
        validateNotNumeric(delimiter);
    }

    private static int findFirstNumberIndex(String input) {
        Matcher matcher = RegexPattern.FIRST_NUMBER_PATTERN.matcher(input);
        return matcher.find() ? matcher.start() : -1;
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

    private static void validateCustomDelimiterPosition(int firstNumberIndex, int prefixIndex) {
        if (firstNumberIndex != -1 && firstNumberIndex < prefixIndex) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_MUST_BE_IN_FRONT.getMessage());
        }
    }
}
