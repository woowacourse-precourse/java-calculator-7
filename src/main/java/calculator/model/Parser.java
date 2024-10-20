package calculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private List<String> delimiters = new ArrayList<>(List.of(",", ":"));
    private String input;

    public Parser(String input) {
        this.input = input;
    }

    public List<Integer> parse() {
        if (usesCustomValidator()) {
            findCustomDelimiter();
            input = input.substring(5);
            return getIntegers();
        }
        return getIntegers();
    }

    private List<Integer> getIntegers() {
        List<String> result = new ArrayList<>();
        StringTokenizer st;
        st = new StringTokenizer(input, delimitersToString());
        while (st.hasMoreTokens()) {
            result.add(st.nextToken());
        }
        return result.stream().map(Integer::parseInt).toList();
    }


    private boolean usesCustomValidator() {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private void findCustomDelimiter() {
        String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(),
                CUSTOM_DELIMITER_PREFIX.length() + 1);
        delimiters.add(customDelimiter);
    }

    private String delimitersToString() {
        StringBuilder appendedDelimiters = new StringBuilder();
        for (String delimiter : delimiters) {
            appendedDelimiters.append(delimiter);
        }
        return appendedDelimiters.toString();
    }
}
