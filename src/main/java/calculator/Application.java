package calculator;

import controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        CalculatorController controller = new CalculatorController();
        controller.run();
    }
}
