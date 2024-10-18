package calculator;

import calculator.exception.InvalidNumberException;

import java.util.List;

public class CalculatorNumberList {
    private final List<Integer> numbers;

    public CalculatorNumberList(List<Integer> input) {
        validateNegative(input);
        numbers = input;
    }

    private void validateNegative(List<Integer> input) {
        if (input.stream().anyMatch(i->i < 0)) {
            throw new InvalidNumberException();
        }
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
