package calculator.model;

import java.util.List;

public class Calculate {
    public int sumOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
