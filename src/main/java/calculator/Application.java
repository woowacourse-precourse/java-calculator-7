package calculator;

import calculator.Utils.Config;
import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        Config config = new Config();
        CalculatorController calculatorController = config.calculatorController();
        calculatorController.run();
    }
}
