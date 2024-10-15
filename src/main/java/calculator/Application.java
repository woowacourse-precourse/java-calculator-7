package calculator;

import calculator.controller.CalculationManager;

public class Application {
    public static void main(String[] args) {
        CalculationManager calculationManager = new CalculationManager();
        calculationManager.run();
    }
}
