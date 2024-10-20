package calculator.model;

import static calculator.util.Constants.NONE;

public class InputNumber {
    private String number;

    public InputNumber() {
        this.number = "";
    }

    public void initNumber() {
        this.number = "";
    }

    public void addNumber(String value) {
        number += value;
    }

    public int getNumber() {
        if (number.equals(NONE)) {
            return 0;
        }
        return Integer.parseInt(number);
    }
}
