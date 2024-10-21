package calculator;

import java.util.regex.Pattern;

public class Delimiter {
    private static final String DEFAULT_REGEX = "[,:]";

    // 입력 문자열을 처리하고, 구분자를 적용하여 숫자 배열 반환
    public String[] split(String input) {
        String delimiter = getDelimiter(input);

        if (isCustomDelimiter(input)) {
            input = removeDelimiterDeclaration(input);
        }

        return input.split(delimiter);
    }

    private String getDelimiter(String input) {
        if (isCustomDelimiter(input)) {
            return extractCustomDelimiter(input);
        }
        return DEFAULT_REGEX;
    }

    private boolean isCustomDelimiter(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }

    private String extractCustomDelimiter(String input) {
        int newlineIndex = input.indexOf("\\n");
        String customDelimiter = input.substring(2, newlineIndex);
        return Pattern.quote(customDelimiter);
    }

    public String removeDelimiterDeclaration(String input) {
        int newlineIndex = input.indexOf("\\n");
        return input.substring(newlineIndex + 2); // 커스텀 구분자 선언 제거
    }
}
