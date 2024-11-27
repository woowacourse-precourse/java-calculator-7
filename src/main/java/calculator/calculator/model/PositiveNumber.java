package calculator.calculator.model;

public record PositiveNumber(long value) {
    public PositiveNumber {
        if (value < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
        }
    }
}
