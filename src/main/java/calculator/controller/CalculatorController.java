package calculator.controller;

import calculator.dto.CalculatorRequest;
import calculator.dto.CalculatorResponse;
import calculator.service.CalculatorService;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public CalculatorResponse calculate(CalculatorRequest request) {
        return calculatorService.calculateSum(request);
    }
}
