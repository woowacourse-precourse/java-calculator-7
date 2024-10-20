package calculator.controller.io;

import calculator.error.ErrorMessage;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputSeparator {
    private static final String CUSTOM_REGEX = "^//(.*)\\\\n(.*)";
    private static final String QUOTE_DELIMITER = ",";
    private static final String COLON_DELIMITER = ":";
    private static final String EMPTY_STRING = "";

    public UserInput separate(String input) {
        Matcher customPatternMatcher = Pattern.compile(CUSTOM_REGEX).matcher(input);
        if (customPatternMatcher.matches()) {
            String delimiter = customPatternMatcher.group(1);
            String string = customPatternMatcher.group(2);
            validateDelimiterAndString(delimiter, string);
            return new UserInput(delimiter, string);
        }

        Set<String> possibleDelimiters = extractPossibleDelimiter(input);
        String delimiters = String.join(EMPTY_STRING, possibleDelimiters);
        validateDelimiterAndString(delimiters, input);
        validateStringIsEmpty(input, delimiters);
        return new UserInput(delimiters, input);
    }

    private void validateDelimiterAndString(String delimiter, String string) {
        if (delimiterIsEmpty(delimiter) && !stringIsEmpty(string)) {
            throw new IllegalArgumentException(ErrorMessage.CANNOT_EMPTY_DELIMITER.getDescription());
        }
        if (!delimiterIsEmpty(delimiter) && stringIsEmpty(string)) {
            throw new IllegalArgumentException(ErrorMessage.CANNOT_EMPTY_TEXT.getDescription());
        }
    }

    private Set<String> extractPossibleDelimiter(String input) {
        return Arrays.stream(input.split(EMPTY_STRING))
                .filter(this::isDefaultDelimiters)
                .collect(Collectors.toUnmodifiableSet());
    }

    private boolean isDefaultDelimiters(String string) {
        return string.equals(QUOTE_DELIMITER) || string.equals(COLON_DELIMITER);
    }

    private void validateStringIsEmpty(String input, String delimiters) {
        if (!stringIsEmpty(input)) {
            String quotedDelimiters = "[" + Pattern.quote(delimiters) + "]";
            List<String> availableStrings = Arrays.stream(input.split(quotedDelimiters))
                    .toList();
            if (availableStrings.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.CANNOT_EMPTY_TEXT.getDescription());
            }
        }
    }

    private boolean delimiterIsEmpty(String delimiter) {
        return delimiter.isEmpty();
    }

    private boolean stringIsEmpty(String string) {
        return string.isEmpty();
    }
}