package calculator.model;

public class Term {
    private final String ERROR_MESSAGE = "유효하지 않은 숫자 항입니다: ";
    private final String POSTIVE_REGEX = "\\d+";
    private final int value;

    public Term(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(String value) {
        if (!value.matches(POSTIVE_REGEX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }
}
