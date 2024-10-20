package calculator.numbercalculator;

import calculator.numbercalculator.delimiter.Delimiter;

public class CustomDelimiterProcessor {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public boolean matches(String str) {
        return str.startsWith(CUSTOM_DELIMITER_PREFIX) && str.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    public Delimiter extract(String str) {
        if (matches(str)) {
            return new Delimiter(getCustomDelimiter(str));
        }
        throw new IllegalArgumentException("커스텀 구분자를 추출할 수 없습니다.");
    }

    public String removeCustomDelimiter(String str) {
        if (matches(str)) {
            return str.substring(str.indexOf(CUSTOM_DELIMITER_SUFFIX) + CUSTOM_DELIMITER_SUFFIX.length());
        }
        throw new IllegalArgumentException("커스텀 구분자를 제거할 수 없습니다.");
    }

    private String getCustomDelimiter(String str) {
        return str.substring(CUSTOM_DELIMITER_PREFIX.length(), str.indexOf(CUSTOM_DELIMITER_SUFFIX));
    }
}
