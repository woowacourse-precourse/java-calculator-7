package calculator.model;

import java.util.List;

public class Calculator {
    public long calculate(final List<Long> numbers) {
        return add(numbers);
    }

    private long add(final List<Long> numbers) {
        return numbers.stream()
                .mapToLong(i -> i)
                .sum();
    }
}
