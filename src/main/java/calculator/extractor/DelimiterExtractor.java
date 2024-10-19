package calculator.extractor;

import java.util.regex.Pattern;

public class DelimiterExtractor {

    private static final String DEFAULT_DELIMITERS = "[,:]";  // 기본 구분자 (쉼표, 콜론)

    public String extractDelimiter(String input) {
        if (input.startsWith("//")) {
            return extractCustomDelimiter(input);
        }
        return DEFAULT_DELIMITERS;  // 기본 구분자 사용
    }

    private String extractCustomDelimiter(String input) {
        int delimiterEndIndex = input.indexOf("\\n");
        validateCustomDelimiter(input, delimiterEndIndex);
        String customDelimiter = input.substring(2, delimiterEndIndex);
        return Pattern.quote(customDelimiter) + "|" + DEFAULT_DELIMITERS;
    }

    private void validateCustomDelimiter(String input, int delimiterEndIndex) {
        if (delimiterEndIndex == -1 || delimiterEndIndex == 2) {
            throw new IllegalArgumentException("잘못된 입력 형식: 커스텀 구분자가 누락되었거나 잘못된 형식입니다.");
        }
    }

}
