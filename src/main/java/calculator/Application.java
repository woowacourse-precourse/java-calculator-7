package calculator;

import calculator.controllers.CalculatorController;

public class Application {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController();
        calculatorController.start();
    }
}
