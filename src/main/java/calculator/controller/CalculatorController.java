package calculator.controller;

import calculator.dto.request.CalculateRequest;
import calculator.dto.response.CalculateResponse;
import calculator.service.CalculatorService;

public class CalculatorController {
    private final CalculatorService calculatorService = new CalculatorService();
    public CalculateResponse calculate(CalculateRequest calculation) {
        int result = calculatorService.calculate(calculation.input());
        return CalculateResponse.from(result);
    }
}
