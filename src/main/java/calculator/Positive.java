package calculator;

import java.util.Objects;

public class Positive {

    private static final Positive ZERO = new Positive(0);
    private final int value;

    public Positive(int value) {
        if (isNotPositive(value)) {
            throw new IllegalArgumentException("음수 일 수 없습니다.");
        }
        this.value = value;
    }

    private boolean isNotPositive(int value) {
        return value < 0;
    }

    public static Positive from(String value) {
        if (value.isBlank()) {
            return ZERO;
        }

        return new Positive(toInt(value));
    }

    private static int toInt(String value) {
        return Integer.parseInt(trim(value));
    }

    private static String trim(String value) {
        return value.trim();
    }

    public static Positive zero() {
        return ZERO;
    }

    public Positive sum(Positive positive) {
        return new Positive(this.value + positive.value);
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Positive positive = (Positive) o;
        return value == positive.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
