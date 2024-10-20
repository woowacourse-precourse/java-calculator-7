package calculator.model;

public class Number {
    private final int number;

    public Number(String number) {
        int tempNumber = parseNumber(number);
        validateNumber(tempNumber);
        this.number = tempNumber;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumber(int number){
        if (!isPositiveNumber(number)){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
    private boolean isPositiveNumber(int number){
        if (number >= 0){
            return true;
        }
        return false;
    }
    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자가 아닙니다.");
        }
    }
}
