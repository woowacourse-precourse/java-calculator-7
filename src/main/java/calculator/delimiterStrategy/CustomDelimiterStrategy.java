package calculator.delimiterStrategy;

import java.util.List;

public class CustomDelimiterStrategy implements DelimiterStrategy {
    public static final String startDelimiterPattern = "//";
    public static final String endDelimiterPattern = "\n";

    @Override
    public List<String> decideDelimiter(String userInput) throws IllegalArgumentException {
        String delimiter = extractDelimiter(userInput);
        if (isNumber(delimiter)) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자를 포함하면 안 된다");
        }
        return List.of(delimiter);
    }

    private String extractDelimiter(String userInput) {
        int start = userInput.indexOf(startDelimiterPattern) + startDelimiterPattern.length();
        int end = userInput.indexOf(endDelimiterPattern);
        return userInput.substring(start, end);
    }

    private boolean isNumber(String delimiter) {
        return delimiter.matches(".*\\d.*");
    }
}
