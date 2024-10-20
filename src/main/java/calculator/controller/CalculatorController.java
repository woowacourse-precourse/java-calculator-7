package calculator.controller;

import calculator.dto.request.CalculatorRequest;
import calculator.dto.response.CalculatorResponse;
import calculator.service.CalculatorService;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public CalculatorResponse processInput(CalculatorRequest calculatorRequest) {
        int sum = calculatorService.strCalculator(calculatorRequest.input());
        return CalculatorResponse.from(sum);
    }
}
