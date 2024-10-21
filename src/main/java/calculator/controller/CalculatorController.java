package calculator.controller;

import calculator.service.CalculatorService;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController() {
        this.calculatorService = new CalculatorService();
    }

    public void process() {
        calculatorService.calculate();
    }
}
