package calculator.model;

public interface SumCalculator {

    String calculate(long[] numbers);

    boolean willOverflow(long currentSum, long newNumber);
}
