package calculator;

import calculator.config.AppConfig;
import calculator.controller.StringAddCalculatorController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        StringAddCalculatorController calculatorController = new StringAddCalculatorController(appConfig.calculatorService());
        calculatorController.playCalculator();
    }
}