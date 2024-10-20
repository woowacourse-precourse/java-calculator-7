package calculator.model;

import java.util.List;

public class Calculator {

    public Integer calculateTotal(List<Integer> numbers) {
        return numbers.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}
