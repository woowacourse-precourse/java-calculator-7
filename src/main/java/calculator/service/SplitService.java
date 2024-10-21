package calculator.service;

import java.util.*;

public class SplitService {
    private static final String START_POINT = "//";
    private static final String END_POINT = "\\n";
    private static final String[] BASIC_DELIMITERS = {",", ":"};
    private final Set<String> delimiters = new HashSet<>();

    public SplitService() {
        delimiters.addAll(Arrays.asList(BASIC_DELIMITERS));
    }

    public List<String> split(String input) {
        String expression = extractExpression(input);
        checkStringValidity(expression);
        String[] numbers = expression.split(delimiterSetToString());
        return Arrays.stream(numbers).toList();
    }

    private String extractExpression(String input) {
        if (input.startsWith(START_POINT) && input.contains(END_POINT)) {
            addDelimiter(input);
            int endIndex = input.indexOf(END_POINT);
            return input.substring(endIndex + END_POINT.length());
        }
        return input;
    }

    private void addDelimiter(String input) {
        int startIndex = START_POINT.length();
        int endIndex = input.indexOf(END_POINT);
        String customDelimiter = input.substring(startIndex, endIndex);
        checkStringValidity(customDelimiter);
        delimiters.add(customDelimiter);
    }

    private String delimiterSetToString() {
        StringBuilder builder = new StringBuilder();
        for (String delimiter : delimiters) {
            builder.append(delimiter).append("|");
        }
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }

    private void checkStringValidity(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
