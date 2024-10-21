package calculator.model;

import static calculator.util.Constants.*;

public class Calculator {
    private String inputValue;
    private int sum;
    private Number number;
    private Delimiter delimiter;

    public Calculator(String inputValue, RegDelimiter regDelimiter) {
        this.inputValue = inputValue.substring(
                regDelimiter.getCustomDeliEndIdx() + 1
        );
        this.sum = 0;
        this.number = new Number();
        this.delimiter = new Delimiter(regDelimiter);
    }

    public void calculate() {
        if (inputValue.isEmpty()) {
            return;
        }
        calculateEachInputValue();
        calculateLastInputValue();
    }

    private void calculateEachInputValue() {
        String[] inputValues = inputValue.split("");
        for (int i=0; i<inputValues.length; i++) {
            String eachValue = inputValue.substring(i, i + 1);
            if (isNumber(eachValue)) {
                calculateNumber(eachValue);
            } else {
                calculateDelimiter(eachValue);
            }
        }
    }

    private boolean isNumber(String value) {
        return value.matches(NUMBER_INCLUDING_MINUS_AND_ZERO_REGEX);
    }

    private void calculateNumber(String value) {
        if (number.isNotStarted()) {
            delimiter.validateDelimiter();
            delimiter.initDelimiter();
        }
        number.addNumber(value);
    }

    private void calculateDelimiter(String value) {
        if (delimiter.isNotStarted()) {
            number.validateNumber();
            addNumberToSum(number.getNumberToInt());
            number.initNumber();
        }
        delimiter.updateDelimiterAndMode(value);
    }

    private void addNumberToSum(int number) {
        this.sum += number;
    }

    private void calculateLastInputValue() {
        delimiter.validateDelimiter();
        number.validateNumber();
        addNumberToSum(number.getNumberToInt());
    }

    public Delimiter getInputDelimiter() {
        return delimiter;
    }

    public int getSum() {
        return sum;
    }

    public Number getInputNumber() {
        return number;
    }
}
