package calculator.model;

import java.util.List;

public class NumberSumCalculator {

    private final List<Integer> numbers;

    public NumberSumCalculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int sum() {
        if (numbers.size() == 1) {
            return numbers.getFirst();
        }
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}