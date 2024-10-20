package calculator.model;

import java.util.List;

public class Calculator {

    private final List<Long> numbers;

    public Calculator(List<Long> numbers) {
        this.numbers = numbers;
    }

    public long sum() {
        return numbers.stream()
                .mapToLong(Long::longValue)
                .sum();
    }
}
