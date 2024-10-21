package calculator.domain;

import static calculator.domain.constant.errorMessage.ValueError.OUT_OF_RANGE_RESULT;

import calculator.global.exception.CalculatorException;
import java.util.List;

public class Calculator {

    public int sum(List<Integer> numbers) {
        long sum = numbers.stream()
                .mapToLong(Integer::longValue)
                .sum();

        checkOutOfRange(sum);

        return (int) sum;
    }

    private void checkOutOfRange(long sum) {
        if (sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE) {
            throw new CalculatorException(OUT_OF_RANGE_RESULT);
        }
    }
}
