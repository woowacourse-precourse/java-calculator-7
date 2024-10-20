package calculator;

import calculator.controller.CalculController;

public class Application {
    public static void main(String[] args) {
        CalculController controller = new CalculController();
        controller.start();
    }
}
