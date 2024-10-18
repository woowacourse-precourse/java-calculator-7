package calculator.service;

import calculator.model.CalculationStringFormatter;
import calculator.model.Calculator;

public class CalculatorService {

    private final CalculationStringFormatter calculationStringFormatter;
    private final Calculator calculator;

    public CalculatorService() {
        this.calculationStringFormatter = new CalculationStringFormatter();
        this.calculator = new Calculator();
    }

    public int calculateSumString(String inputString) {
        if (inputString.isEmpty()) {
            return 0;
        }

        calculationStringFormatter.resolveCalculationString(inputString);
        calculator.patchDelimeter(calculationStringFormatter.getCustomDelimiter());
        return calculator.calculate(calculationStringFormatter.getExpression());
    }
}
