package calculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringSplitter {
    private static final int MAX_CUSTOM_DELIMITER_LENGTH = 5;
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public List<String> split(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return splitWithCustomDelimiter(input);
        }
        return splitWithDefaultDelimiter(input);
    }

    private List<String> splitWithCustomDelimiter(String input) {
        int delimiterEnd = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        if (delimiterEnd == -1) {
            throw new IllegalArgumentException("올바른 형식의 커스텀 구분자를 입력해 주세요.");
        }

        String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEnd);
        if (customDelimiter.isEmpty() || customDelimiter.length() > MAX_CUSTOM_DELIMITER_LENGTH) {
            throw new IllegalArgumentException("커스텀 구분자는 1~" + MAX_CUSTOM_DELIMITER_LENGTH + "자 사이여야 합니다.");
        }

        String numbers = input.substring(delimiterEnd + CUSTOM_DELIMITER_SUFFIX.length());
        return Arrays.asList(numbers.split(Pattern.quote(customDelimiter)));
    }

    private List<String> splitWithDefaultDelimiter(String input) {
        return Arrays.asList(input.split(",|:"));
    }
}