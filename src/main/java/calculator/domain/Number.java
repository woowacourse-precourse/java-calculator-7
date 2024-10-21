package calculator.domain;

public class Number {
    private final int value;

    public Number(String value) {
        int parsedValue;
        try {
            parsedValue = Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
        }

        if (parsedValue < 0) {
            throw new IllegalArgumentException("음수 입력값은 허용되지 않습니다.");
        }

        this.value = parsedValue;
    }

    public int addToSum(int sum) {
        return sum + this.value;
    }
}
