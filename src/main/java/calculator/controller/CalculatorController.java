package calculator.controller;

import calculator.service.CalculatorService;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int calculate(String input) {
        return calculatorService.calculateSum(input);
    }
}
