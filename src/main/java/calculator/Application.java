package calculator;

import calculator.controller.Calculator;
import calculator.controller.io.InputHandler;
import calculator.controller.io.OutputHandler;

public class Application {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        Calculator calculator = new Calculator(inputHandler, outputHandler);
        calculator.calculate();
    }
}