package calculator.domain;

import java.util.List;

public class AdditionCalculator implements Calculator {

    @Override
    public long sum(List<Long> numbers) {
        return numbers.stream()
                .mapToLong(Long::longValue)
                .sum();
    }
}