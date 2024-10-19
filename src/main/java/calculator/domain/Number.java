package calculator.domain;

import java.util.List;

public class Number {
    private final List<Integer> numbers;

    public Number(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int sum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
