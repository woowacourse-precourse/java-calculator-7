package calculator.domain;

import calculator.service.CalculatorService;

/**
 * 문자열로 표현된 수식을 계산하는 계산기
 */

public class StringCalculator {
    private final CalculatorService service;

    public StringCalculator() {
        this.service = new CalculatorService();
    }

    public Number calculate(String input) {
        try {
            return service.calculate(input);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}