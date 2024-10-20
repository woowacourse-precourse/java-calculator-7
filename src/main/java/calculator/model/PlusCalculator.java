package calculator.model;

import java.util.List;

public class PlusCalculator extends Calculator {
    @Override
    public int calculate(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}

