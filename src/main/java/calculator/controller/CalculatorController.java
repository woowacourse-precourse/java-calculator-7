package calculator.controller;

import calculator.service.CalculatorService;

public class CalculatorController {

    private final CalculatorService calculatorService = new CalculatorService();

    public Integer getNumberTotal(String input) {
        return calculatorService.calculateNumberTotal(input);
    }
}
