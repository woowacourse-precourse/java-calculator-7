package calculator;

import java.util.regex.Pattern;

public class CustomDelimiterParser {
    private static final String DEFAULT_DELIMITER = ",|:";
    private String delimiter = DEFAULT_DELIMITER;

    public String[] parse(String input) {
        if (input.startsWith("//")) {
            input = handleCustomDelimiter(input);
        }
        return input.split(delimiter);
    }

    private String handleCustomDelimiter(String input) {
        int newLineIndex = input.indexOf("\\n");
        if (newLineIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자 지정 후 \\n이 없습니다.");
        }

        String customDelimiter = input.substring(2, newLineIndex);
        validateCustomDelimiter(customDelimiter);

        delimiter += "|" + Pattern.quote(customDelimiter);
        return input.substring(newLineIndex + 2);
    }

    private void validateCustomDelimiter(String customDelimiter) {
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.");
        }
        if (customDelimiter.codePoints().count() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 정확히 하나의 유니코드 문자여야 합니다.");
        }
    }
}
