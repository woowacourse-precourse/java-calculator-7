package calculator;

import java.util.Objects;

public class Delimiter {

    private static final String COMMA_DELIMITER = ",";
    private static final String COLON_DELIMITER = ":";

    private final String value;

    public Delimiter(String value) {
        this.value = value;
    }

    public static Delimiter createDefaultDelimiter() {
        return new Delimiter(COMMA_DELIMITER + COLON_DELIMITER);
    }

    public static Delimiter createCustomDelimiter(String value) {
        if (!value.startsWith("//") || !value.contains("\\n")) {
            throw new IllegalArgumentException("[ERROR] 커스텀 구분자가 잘못된 형식입니다. 형식은 '//'와 구분자, 그리고 '\\n'으로 시작해야 합니다.");
        }

        String customDelimiter = value.substring(2, value.indexOf("\\n"));
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 커스텀 구분자가 존재하지 않습니다.");
        }
        return new Delimiter(customDelimiter);
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
