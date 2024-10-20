package calculator.model;

import calculator.util.Validations;

public class InputNumber {
    private String number;

    public InputNumber() {
        this.number = "";
    }

    public boolean isNotStarted() {
        return number.isEmpty();
    }

    public void addNumber(String value) {
        number += value;
    }

    public void initNumber() {
        this.number = "";
    }

    public void validate() {
        Validations.validatePositiveNumber(number);
        Validations.validateNumberMaxLength(number);
    }

    public int getNumberToInt() {
        if (number.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(number);
    }
}
