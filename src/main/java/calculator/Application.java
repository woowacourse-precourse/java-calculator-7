package calculator;

import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController();
        calculatorController.run();
    }
}
