package calculator.domain;

public class Number {

    private final int value;

    public Number(String element) {
        if (element.isEmpty() || element.isBlank()) {
            this.value = 0;
            return;
        }
        validateFormat(element);
        int value = Integer.parseInt(element);
        validateNumberRange(value);
        this.value = value;
    }

    private static void validateFormat(String element) {
        try {
            Integer.valueOf(element);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException("숫자의 형식이 올바르지 않습니다.");
        }
    }

    private void validateNumberRange(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("숫자는 양수여야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
