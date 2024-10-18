package calculator.controller;

import calculator.service.CalculatorService;

public class CalculatorController {
    private final CalculatorService calculatorService = new CalculatorService();

    public int input(String input) {
        return calculatorService.calculate(input);
    }
}
