package calculator;

public class Number {
    private String number;

    public Number(String number) {
        validate(number);
        this.number = number;
    }

    private static void validate(String number) {
        if (number.isBlank()) {
            throw new IllegalArgumentException("숫자에 빈값을 입력할수 없습니다");
        }
        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException("숫자외에 다른 값을 입력할수 없습니다");
        }
        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException("음수를 입력할수 없습니다");
        }
    }

    public String getNumber() {
        return number;
    }
}
