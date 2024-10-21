package calculator.validation;

public class CalculatorValidation {

    public int validateParseInt(String strNum) {
        try {
            return Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력하였습니다.");
        }
    }

    public void validatePositiveNumber(int num) {
        if (num <= 0)
            throw new IllegalArgumentException("양수가 아닌 값을 입력하였습니다.");
    }

    public int validatePlusOverflow(int sum, int num) {
        if (sum > Integer.MAX_VALUE - num)
            throw new IllegalArgumentException("더할 수 있는 값 범위를 초과하였습니다.");
        return sum + num;
    }
}
