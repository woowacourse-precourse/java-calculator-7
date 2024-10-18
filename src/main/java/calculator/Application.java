package calculator;

import calculator.controller.CalculatorProcess;

public class Application {
    public static void main(String[] args) {
        CalculatorProcess calculatorController = new CalculatorProcess();
        calculatorController.run();
    }
}
