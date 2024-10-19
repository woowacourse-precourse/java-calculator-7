package calculator;

import java.util.Objects;

public class Delimiter {

    private static final String COMMA_DELIMITER = ",";
    private static final String COLON_DELIMITER = ":";
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    private final String value;

    public Delimiter(String value) {
        this.value = value;
    }

    public static Delimiter createDefaultDelimiter() {
        return new Delimiter(COMMA_DELIMITER + COLON_DELIMITER);
    }

    public static Delimiter createCustomDelimiter(String value) {
        if (isNotCustomDelimiter(value)) {
            throw new IllegalArgumentException("[ERROR] 커스텀 구분자가 잘못된 형식입니다. 형식은 " + CUSTOM_DELIMITER_PREFIX
                    + "와 구분자, 그리고 " + CUSTOM_DELIMITER_SUFFIX + "으로 시작해야 합니다.");
        }

        String customDelimiter = value.substring(2, value.indexOf(CUSTOM_DELIMITER_SUFFIX));
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 커스텀 구분자가 존재하지 않습니다.");
        }
        return new Delimiter(customDelimiter);
    }

    public static boolean isCustomDelimiter(String value) {
        return value.startsWith(CUSTOM_DELIMITER_PREFIX) && value.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    public static boolean isNotCustomDelimiter(String value) {
        return !isCustomDelimiter(value);
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
}
