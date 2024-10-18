package calculator;

import java.util.List;

public class CalculatorNumberList {
    private final List<Integer> numbers;

    public CalculatorNumberList(List<Integer> input) {
        numbers = input;
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
