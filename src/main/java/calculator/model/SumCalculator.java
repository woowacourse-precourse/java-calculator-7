package calculator.model;

import calculator.common.ErrorMessage;
import java.util.Arrays;

public class SumCalculator {
    public String calculateSum(long[] numbers) {
        long sum = Arrays.stream(numbers)
                .reduce(0L, this::checkOverflowAndAdd);
        return String.valueOf(sum);
    }

    private long checkOverflowAndAdd(long currentSum, long number) {
        if (number > 0 && currentSum > Long.MAX_VALUE - number) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_RESULT.getMessage());
        }
        return currentSum + number;
    }
}
