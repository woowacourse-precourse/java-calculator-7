package calculator.controller;

import java.util.Arrays;
import java.util.List;
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

    public void charExceptDelimiter(String input) {
        if (DEFAULT_DELIMITER_REGEX_PATTERN.matcher(input).find()) {
            throw new IllegalArgumentException();
        }
    }

    public void charExceptDelimiter(String input, String customDelimiter) {
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

    public void number(List<Long> numbers) {
        numbers.stream().filter(num -> {
            if (num < 0) {
                throw new IllegalArgumentException();
            }
            return true;
        });
    }
}
