package calculator.model;

public class NumberValidator {

    public static NumberValidator getInstance() {
        return new NumberValidator();
    }

    private NumberValidator() {

    }

    public void validatePositiveNumbers(String... strNums) {
        for (String strNum : strNums) {
            validatePositive(convertToInteger(strNum));
        }
    }

    private void validatePositive(Integer number) {
        if (number <= 0) {
            throw new IllegalArgumentException("양수가 아닙니다.");
        }
    }

    private Integer convertToInteger(String strNum) {
        return Integer.valueOf(strNum);
    }

}
