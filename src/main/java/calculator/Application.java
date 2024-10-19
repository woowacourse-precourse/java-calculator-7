package calculator;

import calculator.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        appConfig.stringAddCalculatorController().playCalculator();
    }
}