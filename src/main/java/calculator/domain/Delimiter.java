package calculator.domain;

public class Delimiter {
    private final String value;

    private Delimiter(String value) {
        validateNotNullOrEmpty(value);
        validateNotReservedCharacters(value);
        this.value = value;
    }

    public static Delimiter from(String value) {
        return new Delimiter(value);
    }

    private static void validateNotNullOrEmpty(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("구분자는 null 이거나 비어있을 수 없습니다.");
        }
    }

    private static void validateNotReservedCharacters(String value) {
        if ("//".equals(value) || "\n".equals(value)) {
            throw new IllegalArgumentException("구분자는 '//' 이거나 '\\n' 일 수 없습니다.");
        }
    }
    
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Delimiter delimiter = (Delimiter) o;
        return value.equals(delimiter.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
