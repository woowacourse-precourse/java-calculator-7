package calculator.config;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;

public class Configuration {
    private static final Configuration configuration = new Configuration();
    private final CalculatorController calculatorController = new CalculatorController();

    private Configuration() {
    }

    public static Configuration getInstance() {
        return configuration;
    }

    public CalculatorController getCalculatorController() {
        return calculatorController;
    }
}
