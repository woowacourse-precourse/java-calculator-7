package calculator;

public class CustomDelimiterCalculator {
    private final String CUSTOM_DELIMITER_PREFIX = "//";
    private final String CUSTOM_DELIMITER_SUFFIX = "\n";
    private final int CUSTOM_DELIMITER_SIZE = 1;

    public boolean hasCustomDelimiter(String str) {
        return str.startsWith(CUSTOM_DELIMITER_PREFIX) && str.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    public String extractCustomDelimiterFrom(String input) {
        if (hasCustomDelimiter(input)) {
            return getCustomDelimiter(input);
        }
        throw new IllegalArgumentException("커스텀 구분자를 추출할 수 없습니다.");
    }

    public String removeCustomDelimiterPrefix(String str) {
        if (hasCustomDelimiter(str)) {
            int customDelimiterTotalSize = getCustomDelimiterTotalSize();
            return str.substring(customDelimiterTotalSize);
        }
        return str;
    }

    private String getCustomDelimiter(String str) {
        String delimiter = str.substring(CUSTOM_DELIMITER_PREFIX.length(), str.indexOf(CUSTOM_DELIMITER_SUFFIX));
        if (isInvalidCustomDelimiter(delimiter)) {
            throw new IllegalArgumentException("커스텀 구분자는 단일 문자만 올 수 있습니다.");
        }
        return delimiter;
    }

    private boolean isInvalidCustomDelimiter(String delimiter) {
        return delimiter.length() != CUSTOM_DELIMITER_SIZE;
    }

    private int getCustomDelimiterTotalSize() {
        return CUSTOM_DELIMITER_PREFIX.length() + CUSTOM_DELIMITER_SIZE + CUSTOM_DELIMITER_SUFFIX.length();
    }
}
