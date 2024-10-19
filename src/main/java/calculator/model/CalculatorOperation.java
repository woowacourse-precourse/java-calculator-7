package calculator.model;

import java.util.List;

public class CalculatorOperation {

    public int calculateSum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
