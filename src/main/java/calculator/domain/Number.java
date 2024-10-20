package calculator.domain;

public record Number(
    long value
) {
    public Number(long value) {
        this.value = value;
        if (value < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static Number of(long value) {
        return new Number(value);
    }
}