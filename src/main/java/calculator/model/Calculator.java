package calculator.model;

import static calculator.model.Mode.DELI;
import static calculator.model.Mode.WRONG_DELI;

public class Calculator {
    private String inputValue;
    private int sum;
    private InputNumber inputNumber;
    private InputDelimiter inputDelimiter;
    private Mode mode;

    public Calculator(String inputValue, int valueStartIdx) {
        this.inputValue = setInputValue(inputValue, valueStartIdx);
        this.sum = 0;
        this.inputNumber = new InputNumber();
        this.inputDelimiter = new InputDelimiter();
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

    /**
     * 테스트용
     */
    public void updateMode(Mode mode) {
        this.mode = mode;
    }

    private String setInputValue(String inputValue, int valueStartIdx) {
        return inputValue.substring(valueStartIdx);
    }

    public void calculate() {
        String[] inputValues = inputValue.split("");
        for (int i=0; i<inputValues.length; i++) {
            calculateEach(i);
        }
    }

    private void calculateEach(int idx) {
        String value = this.inputValue.substring(idx, idx+1);
        if (isNumber(value)) {
            calculateNumber(idx, value);
            return;
        }
    }

    private void calculateNumber(int idx, String value) {
        validateWrongDelimiter();
        if (this.mode == DELI) {
            validatePositiveNumber(value);
            this.inputDelimiter.initialize();
        }
        inputNumber.addNumber(value);
    }

    public boolean isNumber(String value) {
        String numberIncludingMinusAndZeroRegex = "[0-9-]";
        return value.matches(numberIncludingMinusAndZeroRegex);
    }

    private void validateWrongDelimiter() {
        if (this.mode == WRONG_DELI) {
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
