package calculator.model;

public class Term {
    private final String ERROR_MESSAGE = "유효하지 않은 숫자 항입니다: ";
    private final String POSTIVE_REGEX = "\\d+";
    private final int value;

    public Term(String value) {
        this.value = validate(value);
    }

    private int validate(String value) {
        if (value.isBlank()) {
            return 0;
        }
        validatePostivie(value);
        return Integer.parseInt(value);
    }

    private void validatePostivie(String value) {
        if (hasNotPositiveValue(value)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private boolean hasNotPositiveValue(String value) {
        return !value.matches(POSTIVE_REGEX);
    }

    public int getValue() {
        return value;
    }
}
