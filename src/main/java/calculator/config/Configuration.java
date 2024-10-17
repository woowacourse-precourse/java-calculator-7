package calculator.config;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;

public class Configuration {
    private final CalculatorController calculatorController;

    public Configuration() {
        this.calculatorController = new CalculatorController(new CalculatorService());
    }

    public CalculatorController getCalculatorController() {
        return calculatorController;
    }
}
