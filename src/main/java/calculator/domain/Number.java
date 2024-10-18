package calculator.domain;

public class Number {
    private final int value;

    public Number() {
        this.value = 0;
    }

    public Number(int value) {
        this.value = value;
        validate(value);
    }

    private void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }

}
