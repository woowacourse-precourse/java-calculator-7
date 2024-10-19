package calculator.extractor;

import java.util.regex.Pattern;

public class DelimiterExtractor {

    private static final String DEFAULT_DELIMITERS = "[,:]";
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public String extractDelimiter(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return extractCustomDelimiter(input);
        }
        return DEFAULT_DELIMITERS;
    }

    private String extractCustomDelimiter(String input) {
        int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        validateCustomDelimiter(input, delimiterEndIndex);
        String customDelimiter = input.substring(2, delimiterEndIndex);
        validateNotDefaultDelimiter(customDelimiter);
        return Pattern.quote(customDelimiter) + "|" + DEFAULT_DELIMITERS;
    }

    private void validateCustomDelimiter(String input, int delimiterEndIndex) {
        if (delimiterEndIndex == -1 || delimiterEndIndex == 2) {
            throw new IllegalArgumentException("잘못된 입력 형식: 커스텀 구분자가 누락되었거나 잘못된 형식입니다.");
        }
    }

    private void validateNotDefaultDelimiter(String customDelimiter) {
        if (",".equals(customDelimiter) || ":".equals(customDelimiter)) {
            throw new IllegalArgumentException("쉼표(,)나 콜론(:)은 기본 구분자입니다.");
        }
    }

}
