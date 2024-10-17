package calculator.model;

public class InputNumber {
    private String number;

    public InputNumber() {
        this.number = "";
    }

    public int getNumber() {
        if (number.equals("")) {
            return 0;
        }
        return Integer.parseInt(number);
    }

    public void addNumber(String value) {
        number += value;
    }

    public void initialize() {
        this.number = "";
    }
}
