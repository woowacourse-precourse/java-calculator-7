package calculator.domain.vo.number.constants;

public enum NumberRange {
    ZERO(0);

    private final int value;

    NumberRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
