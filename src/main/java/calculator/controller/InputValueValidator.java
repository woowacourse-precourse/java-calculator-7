package calculator.controller;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValueValidator {
    private static final String DEFAULT_DELIMITER_REGEX = "[^0-9"
            + Arrays.stream(Delimiter.values())
            .map(Delimiter::getDelimiter)
            .collect(Collectors.joining())
            + "]";

    private static final Pattern DEFAULT_DELIMITER_REGEX_PATTERN = Pattern.compile(DEFAULT_DELIMITER_REGEX);

    public void validate(String input) {
        if (DEFAULT_DELIMITER_REGEX_PATTERN.matcher(input).find()) {
            throw new IllegalArgumentException();
        }
    }

    public void validate(String input, String customDelimiter) {
        String regex = "[^0-9"
                + Arrays.stream(Delimiter.values())
                .map(Delimiter::getDelimiter)
                .collect(Collectors.joining())
                + customDelimiter
                + "]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            throw new IllegalArgumentException();
        }
    }
}
