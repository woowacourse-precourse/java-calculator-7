package calculator.model.number;

public class Number {
    private static final int ZERO = 0;
    private final int number;

    protected Number(final String number) {
        this.number = convertNumberToInt(number);
    }

    private int validateNumber(final int number) {
        if (number <= ZERO) {
            throw new IllegalArgumentException("양수인 숫자를 입력해주세요.");
        }
        return number;
    }

    private int convertNumberToInt(final String number) {
        try {
            int num = Integer.parseInt(number);
            return validateNumber(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 값입니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
