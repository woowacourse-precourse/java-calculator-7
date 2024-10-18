package calculator.model;

public class NumberValidator {

    public static NumberValidator getInstance() {
        return new NumberValidator();
    }

    private NumberValidator() {

    }

    public void validatePositiveNumbers(String... strNums) {
        for (String strNum : strNums) {
            convertToInteger(strNum);
        }
    }

    private Integer convertToInteger(String strNum) {
        return Integer.valueOf(strNum);
    }

}
