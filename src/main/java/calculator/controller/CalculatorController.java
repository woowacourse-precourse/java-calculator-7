package calculator.controller;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public CalculationResponseDTO runCalculator(String inputString) {
        return calculatorService.calculate(inputString);
    }
}
