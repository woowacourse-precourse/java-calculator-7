package calculator.domain;

import static calculator.utils.Validator.validateNumberList;

import java.util.List;

public class SimpleCalculator implements Calculator {

    @Override
    public Number calculateSum(List<Double> numbers) {
        validateNumberList(numbers);
        double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();

        if (sum == (long) sum) {
            return (long) sum;
        }
        return sum;
    }
}
