package calculator;

import java.util.Objects;

public class Delimiter {

    private static final String COMMA_DELIMITER = ",";
    private static final String COLON_DELIMITER = ":";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    private final String value;

    public Delimiter(String value) {
        this.value = value;
    }

    public static Delimiter create(String value) {
        if (isCustomDelimiter(value)) {
            return createCustomDelimiter(value);
        }
        return createDefaultDelimiter();
    }

    public static int locateCustomDelimiterSuffix(String value) {
        return value.indexOf(CUSTOM_DELIMITER_SUFFIX);
    }

    public static boolean isCustomDelimiter(String value) {
        return value.startsWith(CUSTOM_DELIMITER_PREFIX) && value.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Delimiter delimiter)) {
            return false;
        }
        return Objects.equals(value, delimiter.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public String getValue() {
        return value;
    }

    private static Delimiter createDefaultDelimiter() {
        return new Delimiter(COMMA_DELIMITER + "|" + COLON_DELIMITER);
    }

    private static Delimiter createCustomDelimiter(String value) {
        String customDelimiter = value.substring(2, locateCustomDelimiterSuffix(value));
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 커스텀 구분자가 존재하지 않습니다.");
        }
        return new Delimiter(customDelimiter);
    }
}
