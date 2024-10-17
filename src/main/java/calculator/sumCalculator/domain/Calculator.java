package calculator.sumCalculator.domain;

import java.util.List;

public class Calculator {

    private final List<Integer> numbers;

    public Calculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Calculator of(List<Integer> numbers) {
        return new Calculator(numbers);
    }

    public Integer sum() {
        return numbers.stream().mapToInt(i -> i).sum();
    }

}
