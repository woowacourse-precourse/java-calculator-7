package calculator.controller;

import calculator.dto.CalculationResponseDTO;
import calculator.service.CalculatorService;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public CalculationResponseDTO runCalculator(String inputString) {
        return calculatorService.calculate(inputString);
    }
}
