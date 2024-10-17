package calculator.domain;

public class Number {

    private final int value;

    public Number(String input) {
        this.value = parseInt(input);
        validatePositive(value);
    }

    public int getValue() {
        return value;
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 형식입니다: " + number);
        }
    }

    private void validatePositive(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수 입력은 불가능합니다: " + num);
        }
    }
}
