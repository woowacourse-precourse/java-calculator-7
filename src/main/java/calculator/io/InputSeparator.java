package calculator.io;

import java.util.Arrays;
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
            return new UserInput(delimiter, string);
        }

        Set<String> possibleDelimiters = extractPossibleDelimiter(input);
        String delimiters = String.join(EMPTY_STRING, possibleDelimiters);
        return new UserInput(delimiters, input);
    }

    private Set<String> extractPossibleDelimiter(String input) {
        return Arrays.stream(input.split(EMPTY_STRING))
                .filter(this::isDefaultDelimiters)
                .collect(Collectors.toUnmodifiableSet());
    }

    private boolean isDefaultDelimiters(String string) {
        return string.equals(QUOTE_DELIMITER) || string.equals(COLON_DELIMITER);
    }
}