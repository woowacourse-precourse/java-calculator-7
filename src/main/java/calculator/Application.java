package calculator;

import calculator.numbercalculator.NumberCalculator;
import calculator.numbercalculator.NumberExtractor;
import calculator.numbercalculator.io.InputHandler;
import calculator.numbercalculator.io.OutputHandler;

public class Application {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        NumberExtractor numberExtractor = new NumberExtractor();

        NumberCalculator numberCalculator = new NumberCalculator(inputHandler, outputHandler, numberExtractor);

        numberCalculator.run();
    }
}
