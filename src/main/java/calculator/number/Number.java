package calculator.number;

public record Number(int value) {

    public Number {
        validate(value);
    }

    public static Number of(String value) {
        int intValue = toInt(value);
        return new Number(intValue);
    }

    private void validate(int value) {
        if (isNotPositive(value)) {
            throw new IllegalArgumentException("숫자는 양수만 올 수 있습니다.");
        }
    }

    private boolean isNotPositive(int value) {
        return value <= 0;
    }

    private static int toInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없습니다.");
        }
    }
}
