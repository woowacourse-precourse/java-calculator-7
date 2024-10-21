package calculator.service;

import calculator.domain.Calculator;

public class CalculatorService {

    public int calculate(String content) {
        Calculator calculator = Calculator.from(content);
        return calculator.sum();
    }
}
