package calculator.parser.utils;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private final String defaultDelimiter;
    private final String customDelimiterPrefix;
    private final String customDelimiterSuffix;

    public Tokenizer(String defaultDelimiter, String customDelimiterPrefix, String customDelimiterSuffix) {
        this.defaultDelimiter = defaultDelimiter;
        this.customDelimiterPrefix = customDelimiterPrefix;
        this.customDelimiterSuffix = customDelimiterSuffix;
    }

    public String removeCustomDelimiterInfo(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        int startIndex = input.indexOf(customDelimiterPrefix);
        int endIndex = input.indexOf(customDelimiterSuffix, startIndex + 1);

        if (endIndex != -1) {
            return input.substring(0, startIndex) + input.substring(endIndex + customDelimiterSuffix.length());
        }

        return input;
    }

    public ArrayList<String> tokenize(String input, Character customDelimiter) {
        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }

        String delimiter = defaultDelimiter;
        if (customDelimiter != null) {
            delimiter = defaultDelimiter + customDelimiter;
            input = removeCustomDelimiterInfo(input);
        }

        return new ArrayList<>(List.of(input.split("[" + delimiter + "]")));
    }
}
