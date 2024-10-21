package calculator.service;

import calculator.model.Delimiters;
import java.util.*;

public class SplitService {
    private static final String START_POINT = "//";
    private static final String END_POINT = "\\n";
    private static final String[] BASIC_DELIMITERS = {",", ":"};
    private final Delimiters delimiters;

    public SplitService() {
        this.delimiters = new Delimiters(BASIC_DELIMITERS);
    }

    public List<String> split(String input) {
        String expression = extractExpression(input);
        checkStringValidity(expression);
        String[] numbers = expression.split(delimiters.toString());
        return Arrays.stream(numbers).toList();
    }

    private String extractExpression(String input) {
        if (input.startsWith(START_POINT) && input.contains(END_POINT)) {
            int startIndex = START_POINT.length();
            int endIndex = input.indexOf(END_POINT);
            String customDelimiter = input.substring(startIndex, endIndex);
            delimiters.addDelimiter(customDelimiter);
            return input.substring(endIndex + END_POINT.length());
        }
        return input;
    }

    private void checkStringValidity(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
