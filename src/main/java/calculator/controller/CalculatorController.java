package calculator.controller;

import calculator.service.CalculatorService;

public class CalculatorController {

    private final CalculatorService calculatorService = new CalculatorService();

    public String calculateSum(String inputString) {
        return calculatorService.calculateSumFormString(inputString);
    }
}
