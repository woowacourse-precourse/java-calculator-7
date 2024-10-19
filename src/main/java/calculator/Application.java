package calculator;

import calculator.Calculator.CalculatorService;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        CalculatorService calculatorService = appConfig.calculatorService();
        calculatorService.calculate();
    }
}
