package calculator;

import calculator.controller.Calculator;
import calculator.io.InputHandler;
import calculator.io.OutputHandler;
import calculator.service.Extractor;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new InputHandler(), new OutputHandler(), new Extractor());
        calculator.run();
    }
}
