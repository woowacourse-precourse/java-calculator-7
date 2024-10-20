package calculator.controller;

import calculator.dto.DelimiterInputDto;
import calculator.service.CalculatorService;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int calculateSum(DelimiterInputDto delimiterInputDto) {
        return calculatorService.calculateSumFormString(delimiterInputDto);
    }
}
