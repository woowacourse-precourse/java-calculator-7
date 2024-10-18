package calculator.controller;

import calculator.service.CalculatorService;
import java.math.BigInteger;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public BigInteger sum(String input) {
        return calculatorService.sum(input);
    }
}
