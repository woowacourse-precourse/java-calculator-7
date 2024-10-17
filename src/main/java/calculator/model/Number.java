package calculator.model;

public class Number {
    private String[] numString;
    private int[] numbers;
    private int sum;

    public Number(String[] numString) {
        this.numString = numString;
        this.sum = 0;
    }

    private boolean isNullString() {
        if (numString == null) {
            return true;
        }
        return false;
    }
}
