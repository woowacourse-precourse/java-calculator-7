package calculator.model;

public class SumCalculator implements Calculator {
    public int calculate(Arithmetic arithmetic) {
        return arithmetic.getArithmetic().stream().mapToInt(Integer::intValue).sum();
    }
}
