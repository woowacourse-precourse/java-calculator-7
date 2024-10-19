package calculator.model.primitive;

public class PositiveNumber {
    private static final int MIN_RANGE = 1;

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
            throw new IllegalArgumentException("양수를 입력해야 합니다.");
        }
    }

    private boolean isOutOfRange(int number) {
        return number < MIN_RANGE;
    }

    public int sumNumber(int sum) {
        return sum + this.number;
    }
}
