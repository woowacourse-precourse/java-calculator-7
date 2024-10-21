package calculator.domain;

import calculator.constant.Constant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {
    public static final String DEFAULT_DELIMITER = ",:";

    public String extract(String input) {
        if (input.startsWith(Constant.CUSTOM_DELIMITER_PREFIX)) {
            Matcher matcher = Pattern.compile(Constant.VALIDATION_REGEX).matcher(input);
            validateFormat(matcher);

            matcher.matches();
            String customDelimiter = matcher.group(1);
            return DEFAULT_DELIMITER + customDelimiter;
        }

        return DEFAULT_DELIMITER;
    }

    private void validateFormat(Matcher matcher) {
        if (matcher.results().count() != 1) {
            throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
        }
    }
}