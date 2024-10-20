package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.NumberExtractor;

import java.util.List;

public class CalculatorService {
    private final Calculator calculator;
    private final NumberExtractor numberExtractor;

    public CalculatorService(Calculator calculator, NumberExtractor numberExtractor) {
        this.calculator = calculator;
        this.numberExtractor = numberExtractor;
    }

    public int calculateSum(String stringToAdd) {
        if (stringToAdd.isBlank()) {
            return 0;
        }
        List<Integer> numbers = numberExtractor.getNumbers(stringToAdd);
        return calculator.sumNumbers(numbers);
    }
}
