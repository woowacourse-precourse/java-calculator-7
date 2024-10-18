package calculator.service;

import calculator.domain.Calculator;

public class CalculatorService {

    public Long getSumResult(Calculator calculator) {
        return calculator.getOperands().stream()
                .mapToLong(Long::valueOf)
                .sum();
    }
}
