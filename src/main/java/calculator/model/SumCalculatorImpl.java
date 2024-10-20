package calculator.model;

import java.util.Arrays;

public class SumCalculatorImpl implements SumCalculator {

    @Override
    public String calculate(long[] numbers) {
        long sum = Arrays.stream(numbers).sum();
        return String.valueOf(sum);
    }

    @Override
    public boolean willOverflow(long currentSum, long newNumber) {
        return newNumber > 0 && currentSum > Long.MAX_VALUE - newNumber;
    }
}
