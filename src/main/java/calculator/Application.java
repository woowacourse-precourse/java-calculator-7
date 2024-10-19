package calculator;

import calculator.config.Configuration;
import calculator.controller.CalculatorController;

public class Application {
    private static final Configuration configuration = Configuration.getInstance();

    public static void main(String[] args) {
        CalculatorController calculatorController = configuration.getCalculatorController();
        calculatorController.input();
    }
}
