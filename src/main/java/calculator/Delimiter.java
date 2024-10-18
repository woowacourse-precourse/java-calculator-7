package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String DEFAULT_DELIMITERS_PATTERN = ",:";
    private static final String CUSTOM_DELIMITERS_START = "//";
    private static final String CUSTOM_DELIMITERS_END = "\\\\n";
    private final String customDelimiter;

    public Delimiter(String input) {
        this.customDelimiter = extractCustomDelimiter(input);
    }

    private String extractCustomDelimiter(String input) {
        if (!input.startsWith(CUSTOM_DELIMITERS_START)) {
            if (!(input.contains(",") || input.contains(":"))) {
                throw new IllegalArgumentException("구분자가 포함돼야합니다.");
            }
            validate(input);
            return null;
        }

        String pattern = String.format("%s(.)%s(.*)", CUSTOM_DELIMITERS_START, CUSTOM_DELIMITERS_END);
        Matcher m = Pattern.compile(pattern).matcher(input);
        if (m.matches()) {
            return m.group(1);  // 커스텀 구분자를 반환
        }
        throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
    }

    public String getDelimiterRegex() {
        if (customDelimiter != null) {
            return customDelimiter;
        }
        return DEFAULT_DELIMITERS;
    }

    private void validate(String input) {
        checkValidDelimiter(input);
    }

    private void checkValidDelimiter(String input) {
        String patternString = String.join("", "^[0-9", Pattern.quote(DEFAULT_DELIMITERS_PATTERN), "]+$");
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(
                    "입력값이 유효하지 않습니다. 숫자 및 허용된 구분자만 사용할 수 있습니다: " + DEFAULT_DELIMITERS_PATTERN);
        }
    }
}
