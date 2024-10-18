package calculator;

import calculator.core.controller.CalculatorCoreController;

public class Application {

    public static void main(String[] args) {
        CalculatorCoreController.getInstance().run();
    }
}
