package calculator.domain;

public class SumCalculator {
    private int result = 0;

    public void sum(char number) {
        int numericValue = Character.getNumericValue(number);
        result += numericValue;
    }

    public int getResult() {
        return result;
    }

}
