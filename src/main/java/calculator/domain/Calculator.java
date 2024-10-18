package calculator.domain;

import calculator.validator.CalculatorValidator;

import java.util.List;

public class Calculator {

    private final NumberStringExtractor numberStringExtractor;

    public Calculator(NumberStringExtractor numberStringExtractor) {
        this.numberStringExtractor = numberStringExtractor;
    }

    public int getSum(String stringToAdd) {
        if (stringToAdd.isBlank()) {
            return 0;
        }
        List<Integer> numbers = numberStringExtractor.getNumbers(stringToAdd);
        return sumNumbers(numbers);
    }

    private int sumNumbers(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            CalculatorValidator.validatePositivity(num);
            sum += num;
        }
        return sum;
    }
}
