package calculator;

public class Number {
    private String number;

    public Number(String number) {
        if (number.isBlank()) {
            throw new IllegalArgumentException("숫자에 빈값을 입력할수 없습니다");
        }
        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException("음수를 입력할수 없습니다");
        }
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
