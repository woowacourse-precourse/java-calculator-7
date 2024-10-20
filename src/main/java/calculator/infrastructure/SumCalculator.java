package calculator.infrastructure;

import calculator.common.exception.OutOfLongRangeException;
import java.util.List;

public class SumCalculator {
    public long addAllNumbers(List<Long> numberList) {
        long sum = 0L;
        for (long number : numberList) {
            try {
                sum = Math.addExact(sum, number);
            } catch (ArithmeticException e) {
                throw new OutOfLongRangeException(sum, number, e);
            }
        }
        return sum;
    }
}
