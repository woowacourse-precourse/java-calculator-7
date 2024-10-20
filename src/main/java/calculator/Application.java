package calculator;

import calculator.calculator.StringCalculator;
import calculator.io.InputProcessor;
import calculator.io.OutputProcessor;

public class Application {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        InputProcessor inputProcessor = new InputProcessor();
        OutputProcessor outputProcessor = new OutputProcessor();

        String input = inputProcessor.getInput();
        int result = calculator.calculate(input);
        outputProcessor.printResult(result);
    }
}