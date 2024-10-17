package calculator.entity;

public class CalculationResult {

    private final int result;

    public CalculationResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "결과: " + result;
    }
}
