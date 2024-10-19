package calculator.controller;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringParser {
    private final String defaultRegex = Arrays.stream(Delimiter.values())
            .map(Delimiter::getDelimiter)
            .collect(Collectors.joining("|"));

    public String[] parseNumber(String input) {
        return input.split(defaultRegex);
    }

    public String[] parseNumber(String input, String customDelimiter) {
        String regex = defaultRegex + "|" + customDelimiter;
        return input.split(regex);
    }
}
