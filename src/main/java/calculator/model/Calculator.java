package calculator.model;

public class Calculator {
    private String inputValue;
    private int sum;

    public Calculator(String inputValue) {
        this.inputValue = inputValue;
        this.sum = 0;
    }

    public boolean isNumber(String value) {
        String numberIncludingMinusAndZeroRegex = "[0-9-]";
        return value.matches(numberIncludingMinusAndZeroRegex);
    }
}
