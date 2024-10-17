package calculator.model;

import java.util.List;

public class Calculator {
    public int calculate(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
