package calculator;

import calculator.controller.CalculatorController;
import calculator.factory.CalculatorFactory;

public class Application {
    public static void main(String[] args) {
        CalculatorController controller = CalculatorFactory.createCalculatorController();
        controller.run();
    }
}
