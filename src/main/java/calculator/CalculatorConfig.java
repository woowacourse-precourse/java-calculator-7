package calculator;

import calculator.service.CalculatorService;
import calculator.service.AdditionService;

public class CalculatorConfig {
    public CalculatorService calculatorService() {
        return new AdditionService();
    }

    public View view() { return new View(); }

    public InputValidator inputValidator() { return new InputValidator(); }
}
