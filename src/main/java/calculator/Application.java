package calculator;

import calculator.sumCalculator.CalculatorController;

public class Application {
    public static void main(String[] args) {
        AppFactory appFactory = new AppFactory();
        CalculatorController calculatorController = appFactory.createCalculatorController();
        calculatorController.sum();
    }
}
