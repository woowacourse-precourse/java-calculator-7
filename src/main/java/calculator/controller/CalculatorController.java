package calculator.controller;

import calculator.dto.CalculationResultDTO;
import calculator.service.CalculatorService;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public CalculationResultDTO calculate(String input) {
        return calculatorService.calculateSum(input);
    }
}