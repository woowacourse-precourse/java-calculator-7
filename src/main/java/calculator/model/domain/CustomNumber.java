package calculator.model.domain;

public class CustomNumber {

    private int number;

    public CustomNumber(int number) {
        validatePositive(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static CustomNumber fromString(String value) {
        return new CustomNumber(parseToInt(value));
    }

    private static Integer parseToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 형식입니다.");
        }
    }

    private void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
    }
}
