package calculator;

import java.util.Objects;

public class Delimiter {

    private final String value;

    public Delimiter(String value) {
        this.value = value;
    }

    public static Delimiter createDefaultDelimiter() {
        return new Delimiter(",:");
    }

    public static Delimiter createCustomDelimiter(String value) {
        return new Delimiter(getCustomDelimiter(value));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final Delimiter delimiter)) {
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

    private static String getCustomDelimiter(String input) {
        if (!input.startsWith("//") || !input.contains("\\n")) {
            throw new IllegalArgumentException("[ERROR] 커스텀 구분자가 잘못된 형식입니다. 형식은 '//'와 구분자, 그리고 '\\n'으로 시작해야 합니다.");
        }

        String customDelimiter = input.substring(2, input.indexOf("\\n"));
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 커스텀 구분자가 존재하지 않습니다.");
        }
        return customDelimiter;
    }
}
