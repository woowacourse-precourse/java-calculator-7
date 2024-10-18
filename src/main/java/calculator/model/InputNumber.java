package calculator.model;

public class InputNumber {
    private String number;

    public InputNumber() {
        this.number = "";
    }

    public void initialize() {
        this.number = "";
    }

    public void addNumber(String value) {
        number += value;
    }

    public int getNumber() {
        if (number.equals("")) {
            return 0;
        }
        return Integer.parseInt(number);
    }
}
