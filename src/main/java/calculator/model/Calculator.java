package calculator.model;

import java.util.List;

public class Calculator {
    public long calculate(List<Long> numbers) {
        return add(numbers);
    }

    public long add(List<Long> numbers) {
        return numbers.stream()
                .mapToLong(i -> i)
                .sum();
    }
}
