package calculator.domain;

import java.util.List;

public class Calculator {
    private final List<Integer> numbers;

    private Calculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Calculator of(List<Integer> numbers) {
        return new Calculator(numbers);
    }

    public int calculateSum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}