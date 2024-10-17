package calculator.parser;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public static final String DEFAULT_DELIMITER_FILTER = "[,:]";
    public static final String DELIMITER_PREFIX = "//";
    public static final String DELIMITER_SUFFIX = "\\n";

    public String[] separate(String input) {
        if (input.startsWith(DELIMITER_PREFIX)) {
            int startIndex = input.indexOf(DELIMITER_SUFFIX);
            String customDelimiter = input.substring(2, startIndex);
            customDelimiter = escapeDelimiter(customDelimiter);
            String numbersPart = input.substring(startIndex + 2);
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
        if (customDelimiter.equals("\\")) {
            customDelimiter = customDelimiter.replace("\\", "\\\\");
        }
        return customDelimiter;
    }
}
