package calculator.model;

public class InputNumber {
    private String number;

    public InputNumber() {
        this.number = "";
    }

    public int getNumber() {
        return Integer.parseInt(number);
    }

    public void addNumber(String value) {
        number += value;
    }
}
