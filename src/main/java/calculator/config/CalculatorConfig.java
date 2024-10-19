package calculator.config;

import calculator.view.View;
import calculator.service.CalculatorService;
import calculator.service.AdditionService;
import calculator.service.InputValidator;

public class CalculatorConfig {
    public CalculatorService calculatorService() {
        return new AdditionService();
    }

    public View view() { return new View(); }

    public InputValidator inputValidator() { return new InputValidator(); }
}
