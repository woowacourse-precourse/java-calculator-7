package calculator.controller;

import calculator.service.CalculatorService;

public class StringAddCalculatorController {

    private final CalculatorService calculatorService;

    public StringAddCalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void playCalculator(String input) {
        System.out.println(calculatorService.calculateSum(input));
    }

}