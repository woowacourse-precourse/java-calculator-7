package calculator.sumCalculator.domain;

import calculator.sumCalculator.util.Validator;

import java.util.List;

public class Calculator {

    private final List<Integer> numbers;

    public Calculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Calculator of(List<Integer> numbers) {
        Validator.validatePositive(numbers);
        return new Calculator(numbers);
    }

    public Integer sum() {
        return numbers.stream().mapToInt(i -> i).sum();
    }

}
