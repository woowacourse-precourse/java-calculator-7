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
        String numbers = addDelimiter(input);
        String[] splitNumbers = numbers.split(delimiterSet.toString());
        return Arrays.stream(splitNumbers).toList();
    }

    public String addDelimiter(String input) {
        if (input.startsWith(START_POINT) && input.contains(END_POINT)) {
            int startIndex = START_POINT.length();
            int endIndex = input.indexOf(END_POINT);
            String customDelimiter = input.substring(startIndex, endIndex);
            delimiterSet.add(customDelimiter);
            return input.substring(endIndex + END_POINT.length());
        }
        return input;
    }

    public void printSet() {
        System.out.println(delimiterSet);
    }
}
