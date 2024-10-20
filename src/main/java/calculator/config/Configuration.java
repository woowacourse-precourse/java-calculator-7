package calculator.config;

import calculator.controller.CalculatorController;

public class Configuration {
    private static final Configuration CONFIGURATION = new Configuration();
    private final CalculatorController calculatorController = new CalculatorController();

    private Configuration() {
    }

    public static Configuration getInstance() {
        return CONFIGURATION;
    }

    public CalculatorController getCalculatorController() {
        return calculatorController;
    }
}
