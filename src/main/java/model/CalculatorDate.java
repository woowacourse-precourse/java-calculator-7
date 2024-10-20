package model;

public class CalculatorDate {
    private final String text;
    private int[] sumNumbers;
    private String[] strings;

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

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }
}
