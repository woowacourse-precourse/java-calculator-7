package calculator;

import calculator.controller.CalculatorController;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

        CalculatorController controller = new CalculatorController();
        controller.run();

    }
}
