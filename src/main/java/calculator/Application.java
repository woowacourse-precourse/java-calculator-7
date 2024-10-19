package calculator;

import calculator.numbercalculator.DelimiterProcessor;
import calculator.numbercalculator.NumberCalculator;
import calculator.numbercalculator.io.InputHandler;
import calculator.numbercalculator.io.OutputHandler;

public class Application {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        DelimiterProcessor delimiterProcessor = new DelimiterProcessor();

        NumberCalculator numberCalculator = new NumberCalculator(inputHandler, outputHandler, delimiterProcessor);

        numberCalculator.run();
    }
}
