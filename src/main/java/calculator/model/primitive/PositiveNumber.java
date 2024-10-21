package calculator.model.primitive;

public class PositiveNumber {

    private static final long MIN_RANGE = 1L;
    private static final String POSITIVE_NUMBER_EXCEPTION_MESSAGE = "양수를 입력해야 합니다.";

    private final long number;

    private PositiveNumber(long number) {
        validateRange(number);
        this.number = number;
    }

    public static PositiveNumber of(long number) {
        return new PositiveNumber(number);
    }

    private void validateRange(long number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private boolean isOutOfRange(long number) {
        return number < MIN_RANGE;
    }

    public long addNumber(long sum) {
        return sum + this.number;
    }
}
