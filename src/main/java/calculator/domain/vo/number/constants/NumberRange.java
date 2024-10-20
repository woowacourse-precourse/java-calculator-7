package calculator.domain.vo.number.constants;

public enum NumberRange {
    CUSTOM_DELIMITER_PREFIX_LENGTH(2),
    CUSTOM_DELIMITER_SUFFIX_LENGTH(2),
    ZERO(0);

    private final int value;

    NumberRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
