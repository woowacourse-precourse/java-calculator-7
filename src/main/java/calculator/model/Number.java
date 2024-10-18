package calculator.model;

public class Number {
    private int number;

    public Number(String number) {
        this.number = convertToInteger(number);
    }

    public int convertToInteger(String number) {
        return Integer.parseInt(number);
    }

    public int getNumber() {
        return number;
    }
}
