package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITERS_START = "//";
    private static final String CUSTOM_DELIMITERS_END = "\\\\n";
    private final String customDelimiter;

    public Delimiter(String input) {
        this.customDelimiter = extractCustomDelimiter(input);
    }

    private String extractCustomDelimiter(String input) {
        String lastChar = input.substring(input.length() - 1);
        try {
            Long.parseLong(lastChar);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("마지막 문자는 숫자여야 합니다.");
        }

        if (!input.startsWith(CUSTOM_DELIMITERS_START)) {
            if (!(input.contains(",") || input.contains(":"))) {
                throw new IllegalArgumentException("구분자가 포함돼야합니다.");
            }
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
}
