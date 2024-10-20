package calculator;

import calculator.config.CalculatorFactory;
import calculator.model.StringCalculator;
import calculator.view.InputHandler;
import calculator.view.OutputHandler;

public class Application {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();

        StringCalculator calculator = CalculatorFactory.createCalculator();

        int result = calculator.add(input);

        OutputHandler outputHandler = new OutputHandler();
        outputHandler.printResult(result);
    }
}
