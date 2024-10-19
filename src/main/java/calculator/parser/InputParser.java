package calculator.parser;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private final String DEFAULT_DELIMITER_FILTER = "[,:]";
    private final String BACKSLASH_ESCAPE = "\\";
    private final String DELIMITER_PREFIX = "//";
    private final String DELIMITER_SUFFIX = BACKSLASH_ESCAPE + "n";
    private final String ZERO = "0";
    private final int PREFIX_LENGTH = 2;
    private final int SUFFIX_LENGTH = 2;

    private static InputParser instance;

    private InputParser() {
    }

    public static InputParser getInstance() {
        if (instance == null) {
            instance = new InputParser();
        }
        return instance;
    }

    public String[] separate(String input) {
        if (input.startsWith(DELIMITER_PREFIX)) {
            int suffixIndex = input.indexOf(DELIMITER_SUFFIX);
            String customDelimiter = input.substring(PREFIX_LENGTH, suffixIndex);
            customDelimiter = escapeDelimiter(customDelimiter);
            String numbersPart = input.substring(suffixIndex + SUFFIX_LENGTH);
            return numbersPart.split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER_FILTER);
    }

    public List<Integer> toInteger(String[] elements) {
        List<Integer> numbers = new ArrayList<>();
        for (String element : elements) {
            numbers.add(Integer.parseInt(element));
        }
        return numbers;
    }

    private String escapeDelimiter(String customDelimiter) {
        if (customDelimiter.contains(BACKSLASH_ESCAPE)) {
            customDelimiter = customDelimiter.replace(BACKSLASH_ESCAPE, BACKSLASH_ESCAPE + BACKSLASH_ESCAPE);
        }
        return customDelimiter;
    }

    public void blankToZero(String[] separated) {
        for (int i = 0; i < separated.length; i++) {
            if (separated[i].isEmpty()) {
                separated[i] = ZERO;
            }
        }
    }
}
