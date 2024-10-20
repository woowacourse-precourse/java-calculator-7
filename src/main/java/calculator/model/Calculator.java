package calculator.model;

import java.util.List;

public class Calculator {
    private Integer accumulator = 0;

    public Integer addAll(List<Integer> numbers) {
        numbers.forEach(x -> {
            checkPositiveNumber(x);
            accumulator += x;
        });
        return accumulator;
    }

    private void checkPositiveNumber(Integer number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
