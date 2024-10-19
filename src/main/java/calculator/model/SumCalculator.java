package calculator.model;

public class SumCalculator {
    public int calculate(Arithmetic arithmetic) {
        return arithmetic.getArithmetic().stream().mapToInt(Integer::intValue).sum();
    }
}
