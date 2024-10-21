package calculator;

import calculator.Manager.CalculatorManager;

public class Application {

    public static void main(String[] args) {
        CalculatorManager manager = CalculatorManager.getInstance();
        manager.run();
    }
}