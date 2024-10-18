package calculator.domain.value;

public class Number {
    private final int value;

    public Number(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(String value) {
        try {
            int num = Integer.parseInt(value);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
