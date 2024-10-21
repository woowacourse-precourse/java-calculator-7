package calculator.controller;

import calculator.service.CalculatorService;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public Number sum(String input) {
        return calculatorService.sum(input);
    }
}
