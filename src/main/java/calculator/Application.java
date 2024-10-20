package calculator;

import calculator.config.Configuration;
import calculator.controller.CalculatorController;

public class Application {
    private static final Configuration CONFIGURATION = Configuration.getInstance();

    public static void main(String[] args) {
        CalculatorController calculatorController = CONFIGURATION.getCalculatorController();
        calculatorController.input();
    }
}
