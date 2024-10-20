package calculator;

import calculator.controller.CalculateController;

public class Application {
    public static void main(String[] args) {
        CalculateController controller = new CalculateController();
        controller.run();
    }
}
