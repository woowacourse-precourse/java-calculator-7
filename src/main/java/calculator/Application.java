package calculator;

import calculator.controller.CalculatorController;

public class Application {

    private static final CalculatorController calculatorController = new CalculatorController();

    public static void main(String[] args) {
        runCalculator();
    }

    private static void runCalculator() {
        calculatorController.run();
    }
}
