package calculator.domain;

public class CalculatorNumber {
    private final long value;

    private CalculatorNumber(long value) {
        validatePositive(value);
        this.value = value;
    }

    public static CalculatorNumber from(String value) {
        try {
            return new CalculatorNumber(parseLong(value));

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "유효하지 않은 숫자 형식입니다: " + value + "\n양의 정수만 사용 가능하며, 소수점, 공백, 문자, 특수 문자는 사용할 수 없습니다."
            );
        }
    }

    private static long parseLong(String value) {
        if (value.isEmpty()) {
            return 0;
        }

        return Long.parseLong(value);
    }

    private static void validatePositive(long value) {
        if (value <= 0) {
            throw new IllegalArgumentException("숫자는 양수여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CalculatorNumber that = (CalculatorNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(value);
    }
}
