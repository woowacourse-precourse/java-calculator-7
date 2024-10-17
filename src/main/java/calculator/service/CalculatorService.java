package calculator.service;

import calculator.model.Calculator;

public class CalculatorService {

    private final CalculationStringFormatter calculationStringFormatter;
    private final Calculator calculator;

    public CalculatorService() {
        this.calculationStringFormatter = new CalculationStringFormatter();
        this.calculator = new Calculator();
    }

    public int calculateSumString(String inputString) {
        String customDelimeter = calculationStringFormatter.resolveCustomDelimeter(inputString);
        String expression = calculationStringFormatter.resolveExpression(inputString);

        calculator.patchDelimeter(customDelimeter);
        calculator.calculate(expression);

        return 0;
    }
}
