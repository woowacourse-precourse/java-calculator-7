package calculator.model;

import static calculator.model.Mode.DELI;
import static calculator.model.Mode.NONE;
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
        this.inputValue = inputValue.substring(
                regDelimiter.getCustomDeliEndIdx() + 1
        );
        this.sum = 0;
        this.inputNumber = new InputNumber();
        this.inputDelimiter = new InputDelimiter();
        this.regDelimiters = regDelimiter.getDelimiters();
        this.mode = Mode.NONE;
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

    public void updateMode(Mode mode) {
        this.mode = mode;
    }

    private void addSum(int number) {
        this.sum += number;
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

    private void calculateNumber(String value) {
        if (isStartOfNumber()) {
            validateWrongDelimiter();
            validatePositiveNumber(value);
            inputDelimiter.initialize();
        }
        inputNumber.addNumber(value);
        updateMode(NUM);
    }

    private boolean isStartOfNumber() {
        return mode != NUM;
    }

    private void calculateDelimiter(String value) {
        if (isStartOfDelimiter()) {
            addSum(inputNumber.getNumber());
            inputNumber.initialize();
        }
        inputDelimiter.addDelimiter(value);
        checkDelimiterAndUpdateMode();
    }

    private void checkDelimiterAndUpdateMode() {
        if (inputDelimiter.isDelimiter(regDelimiters)) {
            inputDelimiter.initialize();
            updateMode(DELI);
        } else {
            updateMode(WRONG_DELI);
        }
    }

    private boolean isStartOfDelimiter() {
        return mode == NUM;
    }

    private void calculateLeftValue() {
        validateWrongDelimiter();
        addSum(inputNumber.getNumber());
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
