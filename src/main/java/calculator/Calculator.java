package calculator;

import java.math.BigDecimal;
import java.util.Arrays;

public class Calculator {
    public BigDecimal calculate(String[] nums) {
        return Arrays.stream(nums)
                .map(Calculator::toBigDecimal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal toBigDecimal(String num) {
        try {
            return new BigDecimal(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
