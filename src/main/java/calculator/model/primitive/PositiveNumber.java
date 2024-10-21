package calculator.model.primitive;

public class PositiveNumber {

    private static final long MIN_RANGE = 1L;
    private static final String POSITIVE_NUMBER_EXCEPTION_MESSAGE = "양수를 입력해야 합니다.";
    private static final String SUM_OVERFLOW_EXCEPTION_MESSAGE = "계산 결과의 범위를 초과했습니다.";

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
        validateOverflow(sum);
        return sum + this.number;
    }

    private void validateOverflow(long sum) {
        if (isSumOverflow(sum)) {
            throw new ArithmeticException(SUM_OVERFLOW_EXCEPTION_MESSAGE);
        }
    }

    private boolean isSumOverflow(long sum) {
        return sum > calculateSafeOverFlowNumber();
    }

    private long calculateSafeOverFlowNumber() {
        return Long.MAX_VALUE - this.number;
    }
}
