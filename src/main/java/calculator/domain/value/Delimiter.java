package calculator.domain.value;


public class Delimiter {
    private final String value;

    public Delimiter(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("커스텀 구분자는 비어 있을 수 없습니다.");
        }
        if (value.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자여야 합니다.");
        }
        if (value.matches("\\d")) {
            throw new IllegalArgumentException("커스텀 구분자에 숫자가 포함될 수 없습니다.");
        }
        this.value = escapeIfSpecialCharacter(value);
    }

    private String escapeIfSpecialCharacter(String value) {
        if (value.matches("[\\W]")) {
            return "\\" + value;
        }
        return value;
    }

    public String toRegex() {
        return value;
    }
}