package calculator.model;

import java.util.List;

public class Calculator {
    private final int result;

    public Calculator(List<Integer> numbers) {
        this.result = calculateSum(numbers);
    }

    public int getResult() {
        return result;
    }

    public int calculateSum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
