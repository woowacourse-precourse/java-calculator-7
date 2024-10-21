package calculator.domain;

import java.util.List;

public class Calculator {
    private List<Integer> numbers;

    public Calculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int calculateSum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
