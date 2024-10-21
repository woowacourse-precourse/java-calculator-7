package calculator.domain;

import java.util.List;

public class TargetNumbers {
    private final List<Integer> numbers;

    public TargetNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int calculateSum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
