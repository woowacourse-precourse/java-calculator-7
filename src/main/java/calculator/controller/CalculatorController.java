package calculator.controller;

import calculator.dto.CalculatorRequest;
import calculator.service.CalculatorService;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void calculate(CalculatorRequest request) {
        calculatorService.calculateSum(request);
    }
}
