package calculator;

import java.util.*;

public class SplitService {
    private static final String START_POINT = "//";
    private static final String END_POINT = "\\n";
    private static final String[] BASIC_DELIMITERS = {",", ":"};
    private final Set<String> delimiterSet = new HashSet<>();

    public SplitService() {
        delimiterSet.addAll(Arrays.asList(BASIC_DELIMITERS));
    }

    public List<String> split(String input) {
        String expressionStr = extractExpression(input);
        String[] numbers = expressionStr.split(delimiterSetToString());
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
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException();
        }
        delimiterSet.add(customDelimiter);
    }

    private String delimiterSetToString() {
        StringBuilder builder = new StringBuilder();
        for (String delimiter : delimiterSet) {
            builder.append(delimiter).append("|");
        }
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }
}
