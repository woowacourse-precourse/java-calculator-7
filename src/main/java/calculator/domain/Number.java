package calculator.domain;

public class Number {

    private Integer number;

    public Number(Integer number) {
        validatePositiveNumber(number);
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    private void validatePositiveNumber(Integer n) {
        if (n <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해야 합니다.");
        }
    }
}
