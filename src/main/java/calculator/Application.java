package calculator;

import calculator.controller.CalculateController;
import calculator.io.InputHandler;
import calculator.io.OutputHandler;

public class Application {
    public static void main(String[] args) {
        CalculateController calculateController = new CalculateController(new InputHandler(), new OutputHandler());
        calculateController.initialize();
        calculateController.run();
    }
}
