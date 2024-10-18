package calculator.model.primitive;

public class PositiveNumber {
    private static final int MIN_RANGE = 0;

    private final int number;

    private PositiveNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public static PositiveNumber create(int number) {
        return new PositiveNumber(number);
    }

    private void validateRange(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }

    private boolean isOutOfRange(int number) {
        return number < MIN_RANGE;
    }

    public int sumNumber(int sum) {
        return sum + this.number;
    }
}
