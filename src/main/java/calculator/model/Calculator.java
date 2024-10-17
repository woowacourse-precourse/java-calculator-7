package calculator.model;

import static calculator.model.Mode.DELI;
import static calculator.model.Mode.NUM;
import static calculator.model.Mode.WRONG_DELI;

import java.util.List;

public class Calculator {
    private String inputValue;
    private int sum;
    private InputNumber inputNumber;
    private InputDelimiter inputDelimiter;
    private List<String> regDelimiters;
    private Mode mode;

    public Calculator(String inputValue, RegDelimiter regDelimiter) {
        this.inputValue = setInputValue(inputValue, regDelimiter);
        this.sum = 0;
        this.inputNumber = new InputNumber();
        this.inputDelimiter = new InputDelimiter();
        this.regDelimiters = setRegDelimiters(regDelimiter);
        this.mode = Mode.NONE;
    }

    public InputDelimiter getInputDelimiter() {
        return inputDelimiter;
    }

    public String getInputValue() {
        return inputValue;
    }

    public int getSum() {
        return sum;
    }

    public InputNumber getInputNumber() {
        return inputNumber;
    }

    public Mode getMode() {
        return mode;
    }

    public void updateMode(Mode mode) {
        this.mode = mode;
    }

    private String setInputValue(String inputValue, RegDelimiter regDelimiter) {
        int valueStartIdx = regDelimiter.getCustomDeliEndIdx() + 1;
        return inputValue.substring(valueStartIdx);
    }

    private List<String> setRegDelimiters(RegDelimiter regDelimiter) {
        return regDelimiter.getDelimiters();
    }

    public void calculate() {
        String[] inputValues = inputValue.split("");
        for (int i=0; i<inputValues.length; i++) {
            calculateEach(i);
        }
    }

    private void calculateEach(int idx) {
        String value = inputValue.substring(idx, idx+1);
        if (isNumber(value)) {
            calculateNumber(idx, value);
        } else {
            calculateDelimiter(idx, value);
        }
    }

    private void calculateNumber(int idx, String value) {
        validateWrongDelimiter();
        if (mode == DELI) {
            validatePositiveNumber(value);
            inputDelimiter.initialize();
        }
        inputNumber.addNumber(value);
        updateMode(NUM);
    }

    private void calculateDelimiter(int idx, String value) {
        if (mode == NUM) {
            addSum(inputNumber.getNumber());
            inputNumber.initialize();
        }
        inputDelimiter.addDelimiter(value);
        if (inputDelimiter.isDelimiter(regDelimiters)) {
            updateMode(DELI);
            inputDelimiter.initialize();
        } else {
            updateMode(WRONG_DELI);
        }
    }

    private void addSum(int number) {
        this.sum += number;
    }

    public boolean isNumber(String value) {
        String numberIncludingMinusAndZeroRegex = "[0-9-]";
        return value.matches(numberIncludingMinusAndZeroRegex);
    }

    private void validateWrongDelimiter() {
        if (mode == WRONG_DELI) {
            throw new IllegalArgumentException("잘못된 구분자입니다. ',', ':' 또는 커스텀 구분자를 사용해주세요.");
        }
    }

    private void validatePositiveNumber(String value) {
        if (value.equals("0")
        || value.equals("-")) {
            throw new IllegalArgumentException("잘못된 숫자입니다. 양수를 입력해주세요.");
        }
    }
}
