package calculator;

public class SumValue {
    private final int value;

    public SumValue(int value) {
        validateNumPositive(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validateNumPositive(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("양수만 입력");
        }
    }
}
