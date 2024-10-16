package calculator;

import calculator.extractor.NumberExtractor;
import calculator.io.InputHandler;
import calculator.io.OutputHandler;

public class Application {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        NumberExtractor numberExtractor = new NumberExtractor();

        Calculator calculator = new Calculator(inputHandler, outputHandler, numberExtractor);

        calculator.run();
    }
}
