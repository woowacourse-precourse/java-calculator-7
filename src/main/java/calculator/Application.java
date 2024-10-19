package calculator;

import calculator.config.AppConfig;
import calculator.controller.StringAddCalculatorController;

public class Application {
    public static void main(String[] args) {
        StringAddCalculatorController calculatorController = AppConfig.config();
        calculatorController.run();
    }
}
