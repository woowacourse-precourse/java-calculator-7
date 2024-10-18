package calculator.service;

import calculator.domain.Calculator;

public class CalculatorService {

    private final Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public Long getSumResult() {
        return calculator.getOperands().stream()
                .mapToLong(Long::valueOf)
                .sum();
    }
}
