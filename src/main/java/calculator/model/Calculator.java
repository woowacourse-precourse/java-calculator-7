package calculator.model;

import static calculator.model.Mode.*;
import static calculator.util.Constants.*;
import static calculator.util.Exceptions.*;
import static calculator.util.Validations.validatePositiveNumber;
import static calculator.util.Validations.validateWrongDelimiter;

import calculator.util.Validations;
import java.util.List;

public class Calculator {
    private String inputValue;
    private int sum;
    private InputNumber inputNumber;
    private InputDelimiter inputDelimiter;
    private List<String> regDelimiters;
    private Mode mode;

    public Calculator(String inputValue, RegDelimiter regDelimiter) {
        this.inputValue = inputValue.substring(
                regDelimiter.getCustomDeliEndIdx() + 1
        );
        this.sum = 0;
        this.inputNumber = new InputNumber();
        this.inputDelimiter = new InputDelimiter();
        this.regDelimiters = regDelimiter.getDelimiters();
        this.mode = Mode.NONE;
    }

    public void calculate() {
        if (inputValue.isEmpty()) {
            return;
        }
        calculateInputValue();
        calculateLeftValue();
    }

    private void calculateInputValue() {
        String[] inputValues = inputValue.split("");
        for (int i=0; i<inputValues.length; i++) {
            checkTypeAndCalculate(inputValue.substring(i, i+1));
        }
    }

    private void checkTypeAndCalculate(String value) {
        if (isNumber(value)) {
            calculateNumber(value);
        } else {
            calculateDelimiter(value);
        }
    }

    private boolean isNumber(String value) {
        return value.matches(NUMBER_INCLUDING_MINUS_AND_ZERO_REGEX);
    }

    private void calculateNumber(String value) {
        if (isStartOfNumber()) {
            validateWrongDelimiter(mode);
            validatePositiveNumber(value);
            inputDelimiter.initialize();
        }
        inputNumber.addNumber(value);
        updateMode(NUM);
    }

    private boolean isStartOfNumber() {
        return mode != NUM;
    }

    private void updateMode(Mode mode) {
        this.mode = mode;
    }

    private void calculateDelimiter(String value) {
        if (isStartOfDelimiter()) {
            addSum(inputNumber.getNumber());
            inputNumber.initialize();
        }
        inputDelimiter.addDelimiter(value);
        checkDelimiterAndUpdateMode();
    }

    private boolean isStartOfDelimiter() {
        return mode == NUM;
    }

    private void addSum(int number) {
        this.sum += number;
    }

    private void checkDelimiterAndUpdateMode() {
        if (inputDelimiter.isDelimiter(regDelimiters)) {
            inputDelimiter.initialize();
            updateMode(DELI);
        } else {
            updateMode(WRONG_DELI);
        }
    }

    private void calculateLeftValue() {
        validateWrongDelimiter(mode);
        addSum(inputNumber.getNumber());
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
