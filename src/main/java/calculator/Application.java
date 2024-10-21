package calculator;

import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        try {
            CalculatorController controller = new CalculatorController();
            controller.run();
        } catch (IllegalArgumentException e) {
            System.out.println("[error] " + e.getMessage());
            return;
        }
        System.out.println();
    }
}
