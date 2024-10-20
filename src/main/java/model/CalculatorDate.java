package model;

public class CalculatorDate {
    private final String text;
    private int[] sumNumbers;

    public CalculatorDate(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int[] getSumNumbers() {
        return sumNumbers;
    }

    public void setSumNumbers(int[] sumNumbers) {
        this.sumNumbers = sumNumbers;
    }

}
