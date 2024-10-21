package calculator;

public class Calculator {
    private final CalculatorService calculatorService;

    public Calculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int add(String input) {
        return calculatorService.add(input);
    }
}
