package calculator;

import calculator.io.InputHandler;
import calculator.io.OutputHandler;
import calculator.service.CalculatorService;

public class Application {

    private static InputHandler inputHandler = new InputHandler();
    private static OutputHandler outputHandler = new OutputHandler();
    private static CalculatorService calculatorService = new CalculatorService();

    public static void main(String[] args) {
        String input = inputHandler.consoleInput();

        int result = calculatorService.calculator(input);

        outputHandler.printOutput(result);
    }

}
