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
        if (!isChar(delimiter)) {
            throw new IllegalArgumentException("하나의 문자만 커스텀 구분자로 지정한다");
        }
        return List.of(withoutDelimiterPattern(userInput), delimiter);
    }

    private String withoutDelimiterPattern(String userInput) {
        int endIndex = userInput.indexOf(endDelimiterPattern) + endDelimiterPattern.length();
        return userInput.substring(endIndex);
    }

    private String extractDelimiter(String userInput) {
        int start = userInput.indexOf(startDelimiterPattern) + startDelimiterPattern.length();
        int end = userInput.indexOf(endDelimiterPattern);
        return userInput.substring(start, end);
    }

    private boolean isNumber(String delimiter) {
        return delimiter.matches(".*\\d.*");
    }

    private boolean isChar(String delimiter) {
        return delimiter.length() == 1;
    }
}
