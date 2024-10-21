package calculator.domain;

import calculator.validator.CalculatorValidator;

import java.util.List;

public class Calculator {

    public int sumNumbers(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            CalculatorValidator.validatePositivity(num);
            sum += num;
        }
        return sum;
    }
}
