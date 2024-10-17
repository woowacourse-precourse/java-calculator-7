package calculator.model;

public class Number {
    private final int number;

    public Number(String number) {
        this.number = convertNumberToInt(number);
    }

    public int getNumber() {
        return number;
    }

    private int validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("양수인 숫자를 입력해주세요.");
        }
        return number;
    }

    private int convertNumberToInt(String number) {
        try {
            int num = Integer.parseInt(number);
            return validateNumber(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 값입니다.");
        }
    }
}
