package calculator;

import calculator.controller.Calculator;
import calculator.io.InputHandler;
import calculator.io.OutputHandler;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new InputHandler(), new OutputHandler());
        calculator.run();
    }
}
