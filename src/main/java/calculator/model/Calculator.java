package calculator.model;

import java.util.List;

public class Calculator {

    private final List<Integer> numbers;
    private int result;

    public Calculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void sum() {
        result = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int getResult() {
        return result;
    }
}
