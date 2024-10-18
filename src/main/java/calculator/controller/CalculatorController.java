package calculator.controller;

import calculator.dto.response.CalculatorResponse;
import calculator.dto.request.CalculatorRequest;
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