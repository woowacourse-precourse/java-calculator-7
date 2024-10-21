package calculator.calculator;

import java.util.List;

public class Calculator {
    private final List<Integer> numbers;

    private Calculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Calculator calculate(List<Integer> numbers) {
        return new Calculator(numbers);
    }

    public int sum() {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
