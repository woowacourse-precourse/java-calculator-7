package calculator;

public class Number {
    private final int value;

    public Number(String value) {
        try {
            this.value = Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
