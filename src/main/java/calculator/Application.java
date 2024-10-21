package calculator;

import calculator.io.InputConsoleHandler;
import calculator.io.OutputConsoleHandler;

public class Application {
    public static void main(String[] args) {
        InputConsoleHandler inputConsoleHandler = new InputConsoleHandler();
        OutputConsoleHandler outputConsoleHandler = new OutputConsoleHandler();
        Calculator calculator = new Calculator();

        CalculatorController calculatorController = new CalculatorController(
                inputConsoleHandler,
                outputConsoleHandler,
                calculator
        );

        calculatorController.run();
    }
}
