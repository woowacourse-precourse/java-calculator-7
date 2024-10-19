package calculator;

public class PositiveNumber {

    private final int value;

    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");
        }
    }
}
