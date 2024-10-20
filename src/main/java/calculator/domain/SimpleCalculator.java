package calculator.domain;

import java.util.List;

public class SimpleCalculator implements Calculator {

    @Override
    public Number calculateSum(List<Double> numbers) {
        // 검증 로직 필요
        double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();

        if (sum == (long) sum) {
            return (long) sum;
        }
        return sum;
    }
}
