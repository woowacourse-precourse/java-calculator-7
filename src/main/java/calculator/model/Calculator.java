package calculator.model;

import static calculator.util.Constants.*;

public class Calculator {
    private String inputValue;
    private int sum;
    private InputNumber inputNumber;
    private InputDelimiter inputDelimiter;

    public Calculator(String inputValue, RegDelimiter regDelimiter) {
        this.inputValue = inputValue.substring(
                regDelimiter.getCustomDeliEndIdx() + 1
        );
        this.sum = 0;
        this.inputNumber = new InputNumber();
        this.inputDelimiter = new InputDelimiter(regDelimiter);
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
        if (inputNumber.isNotStarted()) {
            inputDelimiter.validate();
            inputDelimiter.initDelimiter();
        }
        inputNumber.addNumber(value);
    }

    private void calculateDelimiter(String value) {
        if (inputDelimiter.isNotStarted()) {
            inputNumber.validate();
            addNumberToSum(inputNumber.getNumberToInt());
            inputNumber.initNumber();
        }
        inputDelimiter.updateDelimiter(value);
    }

    private void addNumberToSum(int number) {
        this.sum += number;
    }

    private void calculateLastInputValue() {
        inputDelimiter.validate();
        inputNumber.validate();
        addNumberToSum(inputNumber.getNumberToInt());
    }

    public InputDelimiter getInputDelimiter() {
        return inputDelimiter;
    }

    public int getSum() {
        return sum;
    }

    public InputNumber getInputNumber() {
        return inputNumber;
    }
}
