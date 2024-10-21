package calculator.util;

import static calculator.util.Constants.CUSTOM_DELIMITER_PATTERN;
import static calculator.util.Constants.DELIMITER_END_PATTERN;
import static calculator.util.Constants.DELIMITER_START_PATTERN;

import calculator.exception.Exception;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterValidator {

    private static final Pattern DIGIT_PATTERN = Pattern.compile("\\d");

    private final String input;
    private final String delimiter;
    private final Matcher matcher;

    public DelimiterValidator(String input, String delimiter, Matcher matcher) {
        this.input = input;
        this.delimiter = delimiter;
        this.matcher = matcher;
        validate();
    }

    public static void isIncorrectlyPlacedDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            throw new IllegalArgumentException(Exception.INCORRECT_DELIMITER_PLACEMENT.getMessage());
        }
    }

    public void validate() {
        if (invalidCustomDelimiterPattern()) {
            throw new IllegalArgumentException(Exception.INVALID_CUSTOM_DELIMITER.getMessage());
        }
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException(Exception.EMPTY_CUSTOM_DELIMITER.getMessage());
        }
        if (hasNumericCharacter()) {
            throw new IllegalArgumentException(Exception.NUMERIC_CUSTOM_DELIMITER.getMessage());
        }
        if (delimiter.length() > 1) {
            throw new IllegalArgumentException(Exception.CUSTOM_DELIMITER_TOO_LONG.getMessage());
        }
    }

    private boolean invalidCustomDelimiterPattern() {
        return delimiter.contains(DELIMITER_START_PATTERN) || isDelimiterEndPattern(matcher.end());
    }

    private boolean hasNumericCharacter() {
        return matcher.start() == 0 && delimiter.matches(".*" + DIGIT_PATTERN + ".*");
    }

    private boolean isDelimiterEndPattern(int endIndex) {
        return input.length() >= endIndex + 2 && input.startsWith(DELIMITER_END_PATTERN, endIndex);
    }
}