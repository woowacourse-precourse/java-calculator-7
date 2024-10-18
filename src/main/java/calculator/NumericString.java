package calculator;

public class NumericString {

    public static final NumericString ZERO = new NumericString(0);

    private final int number;

    private NumericString(int number) {
        this.number = number;
    }

    public static NumericString of(String str, int min) {
        validateIsBlank(str);
        validateIsNumber(str);

        try {
            int number = Integer.parseInt(str);
            validateMinNumber(number, min);

            return new NumericString(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Integer 형식으로 변환할 수 없는 값입니다.");
        }
    }

    private static void validateMinNumber(int number, int min) {
        if (number < min) {
            throw new IllegalArgumentException("숫자는 " + min + "보다 같거나 커야 합니다.");
        }
    }

    private static void validateIsNumber(String str) {
        if (!str.matches("\\d+")) {
            throw new IllegalArgumentException("숫자로 이루어진 문자열이 아닙니다.");
        }
    }

    private static void validateIsBlank(String str) {
        if (str.isBlank()) {
            throw new IllegalArgumentException("빈 문자열 값입니다.");
        }
    }

    public NumericString add(NumericString other) {
        int newNumber = number + other.number;
        if (newNumber < 0) {
            throw new IllegalArgumentException("숫자값을 더할때 " + Integer.MAX_VALUE + " 값을 넘어섰습니다.");
        }
        return new NumericString(this.number + other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
