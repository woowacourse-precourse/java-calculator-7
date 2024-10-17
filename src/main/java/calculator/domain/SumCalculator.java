package calculator.domain;

public class SumCalculator {
    private int result = 0;

    public void sum(int number) {
        result += number;
    }

    public int getResult() {
        return result;
    }

}
