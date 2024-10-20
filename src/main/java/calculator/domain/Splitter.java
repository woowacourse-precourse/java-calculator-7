package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Splitter {

    private static final String PART_SEPARATOR = "\\n";
    private static final String EMPTY_STRING = "";
    private static final String CONTAIN_DELIMITER_REGEX = "^//(.)\\\\n.*";

    private final DelimiterExtractor delimiterExtractor;

    public Splitter() {
        this.delimiterExtractor = new DelimiterExtractor();
    }

    public List<String> split(String input) {
        String numberPart = findNumberPart(input);
        String delimiterPart = findDelimiterPart(input);

        Set<Character> delimiters = delimiterExtractor.extractDelimiters(delimiterPart);

        return splitByDelimiters(numberPart, delimiters);
    }

    private String findNumberPart(String input) {
        if (isContainDelimiter(input)) {
            return input.substring(input.indexOf(PART_SEPARATOR) + PART_SEPARATOR.length());
        }

        return input;
    }

    private String findDelimiterPart(String input) {
        if (isContainDelimiter(input)) {
            return input.substring(0, input.indexOf(PART_SEPARATOR) + PART_SEPARATOR.length());
        }

        return EMPTY_STRING;
    }

    private boolean isContainDelimiter(String input) {
        return input.matches(CONTAIN_DELIMITER_REGEX);
    }

    private List<String> splitByDelimiters(String numberPart, Set<Character> delimiters) {
        List<String> splitNumbers = new ArrayList<>();
        StringBuilder currentPart = new StringBuilder();

        for (char c : numberPart.toCharArray()) {
            if (delimiters.contains(c)) {
                splitNumbers.add(currentPart.toString());
                currentPart.setLength(0);
            } else {
                currentPart.append(c);
            }
        }

        if (!currentPart.isEmpty()) {
            splitNumbers.add(currentPart.toString());
        }

        return splitNumbers;
    }
}
