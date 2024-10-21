package calculator.infrastructure;

import calculator.common.exception.OutOfLongRangeException;
import calculator.domain.Number;
import java.util.List;

public class SumCalculator {
    public long addAllNumbers(List<Number> numberList) {
        long sum = 0L;
        for (Number number : numberList) {
            try {
                sum = Math.addExact(sum, number.getNumberValue());
            } catch (ArithmeticException e) {
                throw new OutOfLongRangeException(sum, number.getNumberValue(), e);
            }
        }
        return sum;
    }
}
