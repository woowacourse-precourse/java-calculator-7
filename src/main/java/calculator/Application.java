package calculator;

import calculator.core.controller.CalculateController;

public class Application {

    public static void main(String[] args) {
        CalculateController.getInstance().run();
    }
}
