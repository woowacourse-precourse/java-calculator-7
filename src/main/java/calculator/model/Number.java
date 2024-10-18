package calculator.model;

public class Number {
    private int number;

    public Number(String number) {
        validate(number);
        this.number = convertToInteger(number);
    }

    public int convertToInteger(String number) {

        return Integer.parseInt(number);
    }

    public int getNumber() {
        return number;
    }


    public void validate(String number) {
        validateNumeric(number);
        validateRange(number);
    }

    public void validateNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
        }
    }

    public void validateRange(String number) {
        if (Integer.parseInt(number) < 1) {
            throw new IllegalArgumentException("숫자는 양의 정수만 입력 가능합니다.");
        }
        ;
    }
}
