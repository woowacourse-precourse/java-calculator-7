package calculator.model;

public class NumberValidator {

    public static NumberValidator getInstance() {
        return new NumberValidator();
    }

    private NumberValidator() {

    }

    public void validateNumbers(String... strNums) {
        for (String strNum : strNums) {
            validateNumber(strNum);
        }
    }

    private Integer validateNumber(String strNum) {
        return Integer.valueOf(strNum);
    }

}
