package calculator.parser.util;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private final String defaultDelim;
    private final String delimPrefix;
    private final String delimSuffix;

    public Tokenizer(String defaultDelim, String delimPrefix, String delimSuffix) {
        this.defaultDelim = defaultDelim;
        this.delimPrefix = delimPrefix;
        this.delimSuffix = delimSuffix;
    }

    public String removeCustomDelimiterInfo(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        int startIndex = input.indexOf(delimPrefix);
        int endIndex = input.indexOf(delimSuffix, startIndex + 1);

        if (endIndex != -1) {
            return input.substring(0, startIndex) + input.substring(endIndex + delimSuffix.length());
        }

        return input;
    }

    public ArrayList<String> tokenize(String input, Character customDelimiter) {
        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }

        String delimiter = defaultDelim;
        if (customDelimiter != null) {
            delimiter = defaultDelim + customDelimiter;
            input = removeCustomDelimiterInfo(input);
        }

        return new ArrayList<>(List.of(input.split("[" + delimiter + "]")));
    }
}
