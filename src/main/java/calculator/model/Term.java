package calculator.model;

public class Term {
    private final int value;

    public Term(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(String value) {
        if (!value.matches("\\d+")) {
            throw new IllegalArgumentException("유효하지 않은 숫자 항입니다: " + value);
        }
    }

    public int getValue() {
        return value;
    }
}
