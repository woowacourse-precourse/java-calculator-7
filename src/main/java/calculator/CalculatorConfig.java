package calculator;

import calculator.service.CalculatorService;
import calculator.service.AdditionService;

public class CalculatorConfig {
    public CalculatorService calculatorService() {
        return new AdditionService();
    }
}
