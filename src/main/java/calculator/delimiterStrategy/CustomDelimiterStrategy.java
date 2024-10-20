package calculator.delimiterStrategy;

import java.util.List;

public class CustomDelimiterStrategy implements DelimiterStrategy {
    public static final String startDelimiterPattern = "//";
    public static final String endDelimiterPattern = "\n";

    @Override
    public List<String> decideDelimiter(String userInput) {
        String delimiter = extractDelimiter(userInput);
        return List.of(delimiter);
    }

    private String extractDelimiter(String userInput) {
        int start = userInput.indexOf(startDelimiterPattern) + startDelimiterPattern.length();
        int end = userInput.indexOf(endDelimiterPattern);
        return userInput.substring(start, end);
    }
}
